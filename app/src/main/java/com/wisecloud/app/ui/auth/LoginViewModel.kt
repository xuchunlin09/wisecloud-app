package com.wisecloud.app.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.local.TokenManager
import com.wisecloud.app.data.repository.AuthRepository
import com.wisecloud.app.data.repository.Result
import com.wisecloud.app.util.InputValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class VerifyMethod { EMAIL, MFA }

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val token: String) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
    object NetworkError : LoginUiState()
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenManager: TokenManager
) : ViewModel() {

    private val _loginState = MutableLiveData<LoginUiState>(LoginUiState.Idle)
    val loginState: LiveData<LoginUiState> = _loginState

    private val _countdownSeconds = MutableLiveData(0)
    val countdownSeconds: LiveData<Int> = _countdownSeconds

    private val _verifyMethod = MutableLiveData(VerifyMethod.EMAIL)
    val verifyMethod: LiveData<VerifyMethod> = _verifyMethod

    private val _savedEmail = MutableLiveData<String>()
    val savedEmail: LiveData<String> = _savedEmail

    private val _savedPassword = MutableLiveData<String>()
    val savedPassword: LiveData<String> = _savedPassword

    private var countdownJob: Job? = null

    fun login(email: String, password: String, verifyCode: String) {
        if (!InputValidator.isValidEmail(email)) {
            _loginState.value = LoginUiState.Error("Invalid email format")
            return
        }
        if (!InputValidator.isValidPassword(password)) {
            _loginState.value = LoginUiState.Error("Password must be at least 8 characters")
            return
        }

        val method = _verifyMethod.value ?: VerifyMethod.EMAIL
        if (method == VerifyMethod.MFA) {
            if (!InputValidator.isValidMfaCode(verifyCode)) {
                _loginState.value = LoginUiState.Error("MFA code must be 6 digits")
                return
            }
        } else {
            if (!InputValidator.isValidVerificationCode(verifyCode)) {
                _loginState.value = LoginUiState.Error("Verification code is required")
                return
            }
        }

        _loginState.value = LoginUiState.Loading

        viewModelScope.launch {
            val methodStr = if (method == VerifyMethod.EMAIL) "email" else "mfa"
            when (val result = authRepository.login(email, password, verifyCode, methodStr)) {
                is Result.Success -> {
                    _loginState.value = LoginUiState.Success(result.data.token)
                }
                is Result.Error -> {
                    _loginState.value = LoginUiState.Error(result.message)
                }
                is Result.NetworkError -> {
                    _loginState.value = LoginUiState.NetworkError
                }
                is Result.Loading -> { /* no-op */ }
            }
        }
    }

    fun sendVerificationCode(email: String) {
        if (!InputValidator.isValidEmail(email)) {
            _loginState.value = LoginUiState.Error("Invalid email format")
            return
        }
        if ((_countdownSeconds.value ?: 0) > 0) return

        viewModelScope.launch {
            when (val result = authRepository.sendCode(email)) {
                is Result.Success -> startCountdown()
                is Result.Error -> {
                    _loginState.value = LoginUiState.Error(result.message)
                }
                is Result.NetworkError -> {
                    _loginState.value = LoginUiState.NetworkError
                }
                is Result.Loading -> { /* no-op */ }
            }
        }
    }

    private fun startCountdown() {
        countdownJob?.cancel()
        countdownJob = viewModelScope.launch {
            for (i in 60 downTo 0) {
                _countdownSeconds.value = i
                if (i > 0) delay(1000L)
            }
        }
    }

    fun switchVerifyMethod() {
        val current = _verifyMethod.value ?: VerifyMethod.EMAIL
        _verifyMethod.value = if (current == VerifyMethod.EMAIL) VerifyMethod.MFA else VerifyMethod.EMAIL
    }

    fun loadSavedCredentials() {
        val credentials = tokenManager.getSavedCredentials()
        if (credentials != null) {
            _savedEmail.value = credentials.first
            _savedPassword.value = credentials.second
        }
    }

    fun saveCredentials(email: String, password: String, remember: Boolean) {
        if (remember) {
            tokenManager.saveCredentials(email, password)
        } else {
            tokenManager.clearCredentials()
        }
    }
}

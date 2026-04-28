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
import kotlinx.coroutines.launch
import javax.inject.Inject

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

    private val _savedUsername = MutableLiveData<String>()
    val savedUsername: LiveData<String> = _savedUsername

    private val _savedPassword = MutableLiveData<String>()
    val savedPassword: LiveData<String> = _savedPassword

    fun login(username: String, password: String) {
        if (!InputValidator.isValidUsername(username)) {
            _loginState.value = LoginUiState.Error("请输入用户名")
            return
        }

        _loginState.value = LoginUiState.Loading

        viewModelScope.launch {
            when (val result = authRepository.login(username, password)) {
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

    fun loadSavedCredentials() {
        val credentials = tokenManager.getSavedCredentials()
        if (credentials != null) {
            _savedUsername.value = credentials.first
            _savedPassword.value = credentials.second
        }
    }

    fun saveCredentials(username: String, password: String, remember: Boolean) {
        if (remember) {
            tokenManager.saveCredentials(username, password)
        } else {
            tokenManager.clearCredentials()
        }
    }
}

package com.wisecloud.app.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.repository.AuthRepository
import com.wisecloud.app.data.repository.Result
import com.wisecloud.app.util.InputValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class RegisterUiState {
    object Idle : RegisterUiState()
    object Loading : RegisterUiState()
    object Success : RegisterUiState()
    data class Error(val message: String) : RegisterUiState()
    object NetworkError : RegisterUiState()
}

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _registerState = MutableLiveData<RegisterUiState>(RegisterUiState.Idle)
    val registerState: LiveData<RegisterUiState> = _registerState

    fun register(username: String, password: String, confirmPassword: String) {
        if (!InputValidator.isValidUsername(username)) {
            _registerState.value = RegisterUiState.Error("请输入用户名")
            return
        }
        if (!InputValidator.isValidPassword(password)) {
            _registerState.value = RegisterUiState.Error("密码长度不足")
            return
        }
        if (password != confirmPassword) {
            _registerState.value = RegisterUiState.Error("两次密码输入不一致")
            return
        }

        _registerState.value = RegisterUiState.Loading

        viewModelScope.launch {
            when (val result = authRepository.register(username, password)) {
                is Result.Success -> {
                    _registerState.value = RegisterUiState.Success
                }
                is Result.Error -> {
                    _registerState.value = RegisterUiState.Error(result.message)
                }
                is Result.NetworkError -> {
                    _registerState.value = RegisterUiState.NetworkError
                }
                is Result.Loading -> { /* no-op */ }
            }
        }
    }
}

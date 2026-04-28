package com.wisecloud.app.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.wisecloud.app.R
import com.wisecloud.app.databinding.FragmentLoginBinding
import com.wisecloud.app.util.gone
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        observeViewModel()
        viewModel.loadSavedCredentials()
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener { performLogin() }

        binding.btnGetCode.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            viewModel.sendVerificationCode(email)
        }

        binding.btnSwitchMethod.setOnClickListener {
            viewModel.switchVerifyMethod()
        }
    }

    private fun performLogin() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString()
        val verifyCode = when (viewModel.verifyMethod.value) {
            VerifyMethod.MFA -> binding.mfaInputView.getCode()
            else -> binding.etVerifyCode.text.toString().trim()
        }

        // Save credentials preference
        viewModel.saveCredentials(
            email,
            password,
            binding.cbRemember.isChecked
        )

        viewModel.login(email, password, verifyCode)
    }

    private fun observeViewModel() {
        viewModel.loginState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoginUiState.Idle -> {
                    binding.progressBar.gone()
                    binding.btnLogin.isEnabled = true
                }
                is LoginUiState.Loading -> {
                    binding.progressBar.visible()
                    binding.btnLogin.isEnabled = false
                }
                is LoginUiState.Success -> {
                    binding.progressBar.gone()
                    binding.btnLogin.isEnabled = true
                    navigateToDashboard()
                }
                is LoginUiState.Error -> {
                    binding.progressBar.gone()
                    binding.btnLogin.isEnabled = true
                    // Show error but preserve email input
                    Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                }
                is LoginUiState.NetworkError -> {
                    binding.progressBar.gone()
                    binding.btnLogin.isEnabled = true
                    Snackbar.make(
                        binding.root,
                        getString(R.string.error_network),
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }

        viewModel.countdownSeconds.observe(viewLifecycleOwner) { seconds ->
            if (seconds > 0) {
                binding.btnGetCode.isEnabled = false
                binding.btnGetCode.text = getString(R.string.countdown_format, seconds)
            } else {
                binding.btnGetCode.isEnabled = true
                binding.btnGetCode.text = getString(R.string.btn_get_code)
            }
        }

        viewModel.verifyMethod.observe(viewLifecycleOwner) { method ->
            when (method) {
                VerifyMethod.EMAIL -> {
                    binding.layoutEmailVerify.visible()
                    binding.layoutMfa.gone()
                    binding.btnSwitchMethod.text = getString(R.string.switch_to_mfa)
                }
                VerifyMethod.MFA -> {
                    binding.layoutEmailVerify.gone()
                    binding.layoutMfa.visible()
                    binding.btnSwitchMethod.text = getString(R.string.switch_to_email)
                }
                else -> { /* no-op */ }
            }
        }

        viewModel.savedEmail.observe(viewLifecycleOwner) { email ->
            binding.etEmail.setText(email)
        }

        viewModel.savedPassword.observe(viewLifecycleOwner) { password ->
            binding.etPassword.setText(password)
            if (password.isNotEmpty()) {
                binding.cbRemember.isChecked = true
            }
        }
    }

    private fun navigateToDashboard() {
        findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

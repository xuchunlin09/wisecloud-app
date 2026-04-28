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

        // 默认填充测试账号
        if (binding.etUsername.text.isNullOrEmpty()) {
            binding.etUsername.setText("admin")
            binding.etPassword.setText("admin")
        }
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener { performLogin() }

        binding.btnGoRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun performLogin() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString()

        viewModel.saveCredentials(
            username,
            password,
            binding.cbRemember.isChecked
        )

        viewModel.login(username, password)
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

        viewModel.savedUsername.observe(viewLifecycleOwner) { username ->
            binding.etUsername.setText(username)
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

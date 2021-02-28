package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.R
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.FragmentLoginBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import timber.log.Timber

/**
 * Login page. Demo. Login with email and password.
 * Buttons for Login and Register lead to next page without checks.
 */
class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.isNavigateToWelcomePage.observe(viewLifecycleOwner,
            { isNavigateToWelcomePage: Boolean ->
                Timber.i("isNavigateToWelcomePage was changed to $isNavigateToWelcomePage")
                if (isNavigateToWelcomePage) {
                    navigateToWelcomePage()
                }
            })

        return binding.root
    }

    private fun navigateToWelcomePage() {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController(this).navigate(action)
        Timber.i("Navigate to welcome page")
    }
}
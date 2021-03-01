package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.screens.login.LoginFragmentDirections
import com.udacity.shoestore.screens.login.LoginViewModel
import timber.log.Timber

/**
 * shows welcome texts
 */
class WelcomeFragment : Fragment() {

    private lateinit var viewModel: WelcomeViewModel
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)

        binding.welcomeViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.isNavigateToInstruction.observe(viewLifecycleOwner,
            { isNavigateToInstruction: Boolean ->
                Timber.i("isNavigateToWelcomePage was changed to $isNavigateToInstruction")
                if (isNavigateToInstruction) {
                    navigateToInstruction()
                }
            })

        return binding.root
    }

    private fun navigateToInstruction() {
        val action =  WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
        NavHostFragment.findNavController(this).navigate(action)
        Timber.i("Navigate to instruction screen")
        viewModel.onNavigateToInstructionComplete()
    }
}
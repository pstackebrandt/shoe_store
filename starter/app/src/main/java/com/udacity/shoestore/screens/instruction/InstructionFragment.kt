package com.udacity.shoestore.screens.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import timber.log.Timber

class InstructionFragment : Fragment() {
    private lateinit var viewModel: InstructionViewModel
    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instruction,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)

        binding.instructionViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.isNavigateToShoeList.observe(viewLifecycleOwner,
            { isNavigateToShoeList: Boolean ->
                Timber.i("isNavigateToWelcomePage was changed to $isNavigateToShoeList")
                if (isNavigateToShoeList) {
                    navigateToShoeList()
                }
            })

        return binding.root
    }

    private fun navigateToShoeList() {
        val action =  InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
        NavHostFragment.findNavController(this).navigate(action)
        Timber.i("Navigate to shoe list screen")
        viewModel.onNavigateToShoeListComplete()
    }
}
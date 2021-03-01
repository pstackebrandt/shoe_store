package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections
import timber.log.Timber

class ShoeListFragment : Fragment() {
    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoeListBinding

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
            R.layout.fragment_shoe_list,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel
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
//        val action =  WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
//        NavHostFragment.findNavController(this).navigate(action)
        Timber.i("Navigate to instruction screen")
        viewModel.onNavigateToShoeList()
    }
}
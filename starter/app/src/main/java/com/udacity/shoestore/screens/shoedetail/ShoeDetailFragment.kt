package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoelist.SharedShoeListViewModel
import timber.log.Timber

/**
 * Screen for creation of new [Shoe]. Looks like a detail view.
 */
class ShoeDetailFragment : Fragment() {

    private val sharedViewModel: SharedShoeListViewModel by activityViewModels()
    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.shoeDetailViewModel = viewModel
        binding.sharedShoeListViewModel = sharedViewModel
        binding.lifecycleOwner = this

        sharedViewModel.isNavigateToShoeList.observe(viewLifecycleOwner,
            { isNavigateToShoeDetail: Boolean ->
                Timber.i("isNavigateToShoeDetail was changed to $isNavigateToShoeDetail")
                if (isNavigateToShoeDetail) {
                    navigateToShoeList()
                }
            })

        sharedViewModel.currentShoe.observe(viewLifecycleOwner,
            { currentShoe: Shoe ->
                Timber.i("currentShoe was changed to $currentShoe")
            })

        return binding.root
    }

    private fun navigateToShoeList() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        NavHostFragment.findNavController(this).navigate(action)
        Timber.i("Navigate to shoe list screen")
        sharedViewModel.onNavigateToShoeListComplete()
    }
}
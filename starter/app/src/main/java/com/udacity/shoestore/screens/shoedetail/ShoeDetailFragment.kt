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
import com.udacity.shoestore.screens.shoelist.SharedShoeListViewModel
import timber.log.Timber

/**
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private val sharedViewModel: SharedShoeListViewModel by activityViewModels()
    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var binding: FragmentShoeDetailBinding

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
                    navigateToShoeDetail()
                }
            })

        return binding.root
    }

    private fun navigateToShoeDetail() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        NavHostFragment.findNavController(this).navigate(action)
        Timber.i("Navigate to shoe list screen")
        sharedViewModel.onNavigateToShoeListComplete()
    }
}
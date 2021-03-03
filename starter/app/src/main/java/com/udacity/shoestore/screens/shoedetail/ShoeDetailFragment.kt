package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoelist.ShoeListFragmentDirections
import com.udacity.shoestore.screens.shoelist.ShoeListViewModel
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "shoeName"

/**
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var shoeName: String? = null

    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            shoeName = it.getString(ARG_PARAM1)
        }
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
        binding.lifecycleOwner = this

//        viewModel.shoes.observe(viewLifecycleOwner,
//            { shoes: List<Shoe> ->
//                Timber.i("shoes list was changed to count: ${shoes.count()}")
//                addShoesToShoeList(shoes)
//            })

        viewModel.isNavigateToShoeList.observe(viewLifecycleOwner,
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
        viewModel.onNavigateToShoeListComplete()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param shoeName Parameter 1.
         * @return A new instance of fragment ShoeDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(shoeName: String) =
            ShoeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, shoeName)
                }
            }
    }
}
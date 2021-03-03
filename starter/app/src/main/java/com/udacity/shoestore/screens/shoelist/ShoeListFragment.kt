package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListFragment : Fragment() {
    private lateinit var viewModel: ShoeListViewModel
    private val sharedViewModel: SharedShoeListViewModel by activityViewModels()

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

        sharedViewModel.shoes.observe(viewLifecycleOwner,
            { shoes: List<Shoe> ->
                Timber.i("shoes list was changed to count: ${shoes.count()}")
                addShoesToShoeList(shoes)
            })

        viewModel.isNavigateToShoeDetail.observe(viewLifecycleOwner,
            { isNavigateToShoeDetail: Boolean ->
                Timber.i("isNavigateToShoeDetail was changed to $isNavigateToShoeDetail")
                if (isNavigateToShoeDetail) {
                    navigateToShoeDetail()
                }
            })

        return binding.root
    }

    private fun addShoesToShoeList(shoes: List<Shoe>) {
        for (shoe in shoes) {
            val shoeTextView = TextView(this.context)
            shoeTextView.textSize = 20f
            shoeTextView.setPadding(
                50,
                20,
                20,
                20
            ) // resources.getDimensionPixelSize(R.dimen.shoe_padding))
            shoeTextView.text = shoe.name
            shoeTextView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            binding.shoeItemsLayout.addView(shoeTextView, 1000, 200)
        }

        Timber.i("addShoesToShoeList: add ${shoes.count()} shoes")
    }

    private fun navigateToShoeDetail() {
        val action =  ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        NavHostFragment.findNavController(this).navigate(action)
        Timber.i("Navigate to shoe list screen")
        viewModel.onNavigateToShoeDetailComplete()
    }
}
package com.example.puutuumommy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.puutuumommy.R
import com.example.puutuumommy.adapter.ThanakhatoneTypesAdapter
import com.example.puutuumommy.data.DataSource
import com.example.puutuumommy.databinding.FragmentThanakhatoneBinding
import com.example.puutuumommy.model.OrderViewModel


class ThanakhatoneFragment : Fragment() {


    private var binding: FragmentThanakhatoneBinding? = null
    private val sharedViewModel : OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentBinding = FragmentThanakhatoneBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        val thanakhatoneTypes = DataSource().loadThanakhatoneItems()
        binding?.thanakhatoneTypeRecyclerView?.adapter = ThanakhatoneTypesAdapter(this, thanakhatoneTypes)
        return binding?.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.thanakhatoneFragment = this
        binding?.sharedViewModel =  sharedViewModel
    }

    fun orderThanakha(pricePerEach : Int){
        sharedViewModel.setPerItem(pricePerEach)
        findNavController().navigate(R.id.action_startFragment_to_quantityFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
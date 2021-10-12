package com.example.puutuumommy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.puutuumommy.R
import com.example.puutuumommy.adapter.CatalogItemAdapter
import com.example.puutuumommy.data.DataSource
import com.example.puutuumommy.databinding.FragmentCatalogBinding
import com.example.puutuumommy.model.OrderViewModel


class CatalogFragment : Fragment() {
    val sharedViewModel : OrderViewModel by activityViewModels()
    private var binding: FragmentCatalogBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val catalogBinding = FragmentCatalogBinding.inflate(inflater,container,false)
        binding = catalogBinding
        val catalogItemSet = DataSource().loadCatalogItems()

        binding?.catalogRecyclerview?.adapter = CatalogItemAdapter(this
            ,catalogItemSet)


        return binding?.root
    }

    fun goToSelectedItemScreen(){
        if(sharedViewModel.itemType.value== context?.resources?.getString(R.string.catalogItem1)) {
            findNavController().navigate(R.id.action_catalogFragment_to_startFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.sharedViewModel = sharedViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
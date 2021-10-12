package com.example.puutuumommy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.puutuumommy.R
import com.example.puutuumommy.databinding.FragmentQuantityBinding
import com.example.puutuumommy.model.OrderViewModel

class QuantityFragment : Fragment() {
    private val sharedViewModel: OrderViewModel by activityViewModels()
    private var binding: FragmentQuantityBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentQuantityBinding = FragmentQuantityBinding.inflate(inflater,container,false)

        binding = fragmentQuantityBinding
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.quantityFragment = this
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.sharedViewModel = sharedViewModel
    }

    fun gotoNextScreen(){
        findNavController().navigate(R.id.action_quantityFragment_to_addressFragment)
    }

    fun orderCancel(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_quantityFragment_to_startFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
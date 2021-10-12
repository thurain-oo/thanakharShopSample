package com.example.puutuumommy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.puutuumommy.R
import com.example.puutuumommy.databinding.FragmentAddressBinding
import com.example.puutuumommy.model.OrderViewModel


class AddressFragment : Fragment() {
    private var binding: FragmentAddressBinding? = null
    private val sharedViewModel : OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val addressBinding = FragmentAddressBinding.inflate(inflater,container,false)
        binding = addressBinding
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.addressFragment = this
        binding?.sharedViewModel = sharedViewModel
        binding?.lifecycleOwner = viewLifecycleOwner

    }


    fun showAddress(){
        if(sharedViewModel.address.value != null){
            binding?.addressEditText?.setText(sharedViewModel.address.value)
        }
    }
    fun showPhone(){
        if(sharedViewModel.phone.value != null){
            binding?.addressEditText?.setText(sharedViewModel.phone.value)
        }
    }

    fun goToNextScreen(){
        sharedViewModel.setAddress(binding?.addressEditText?.text.toString())
        sharedViewModel.setPhone(binding?.phoneNoEditText?.text.toString())
        findNavController().navigate(R.id.action_addressFragment_to_summaryFragment)
    }

    fun orderCancel(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_addressFragment_to_startFragment)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
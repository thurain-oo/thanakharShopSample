package com.example.puutuumommy.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.puutuumommy.R
import com.example.puutuumommy.databinding.FragmentSummaryBinding
import com.example.puutuumommy.model.OrderViewModel


class SummaryFragment : Fragment() {

    private var binding: FragmentSummaryBinding? = null
    private val sharedViewModel : OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val summaryBinding = FragmentSummaryBinding.inflate(inflater,container,false)
        binding = summaryBinding
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.summaryFragment = this
        binding?.sharedViewModel = sharedViewModel
        binding?.lifecycleOwner = viewLifecycleOwner
    }

    fun orderSummary(){
        val quantity_of_thanakha_tone = sharedViewModel.quantity.value ?:0
        val summary = getString(R.string.order_details,
            sharedViewModel.pricePerItem.value.toString(),
            resources.getQuantityString(R.plurals.quantity_of_thanakha_tone,quantity_of_thanakha_tone,quantity_of_thanakha_tone),
            sharedViewModel.address.value,
            sharedViewModel.phone.value,
            sharedViewModel.totalPrice.value.toString()
        )

        val addresses = arrayOf("mr.zxchero12@gmail.com")
        val intent = Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_EMAIL,addresses)
                .putExtra(Intent.EXTRA_SUBJECT, "New Thanakha Order " )
                .putExtra(Intent.EXTRA_TEXT, summary)

        if (activity?.packageManager?.resolveActivity(intent, 0) != null)
            startActivity(intent)
    }

    fun orderCancel(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
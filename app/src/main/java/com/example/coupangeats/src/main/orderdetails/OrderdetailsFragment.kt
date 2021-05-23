package com.example.coupangeats.src.main.orderdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coupangeats.R
import com.example.coupangeats.databinding.FragmentOrderdetailsBinding

class OrderdetailsFragment : Fragment() {

    private lateinit var orderdetailsViewModel: OrderdetailsViewModel
    private var _binding: FragmentOrderdetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding !!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        orderdetailsViewModel =
            ViewModelProvider(this).get(OrderdetailsViewModel::class.java)

        _binding = FragmentOrderdetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textOrderdetails
        orderdetailsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
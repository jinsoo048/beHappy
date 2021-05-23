package com.example.coupangeats.src.main.myeats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coupangeats.R
import com.example.coupangeats.databinding.FragmentMyeatsBinding

class MyeatsFragment : Fragment() {

    private lateinit var myeatsViewModel: MyeatsViewModel
    private var _binding: FragmentMyeatsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding !!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myeatsViewModel =
            ViewModelProvider(this).get(MyeatsViewModel::class.java)

        _binding = FragmentMyeatsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMyeats
        myeatsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.coupangeats.src.main.myeats

import android.app.Dialog
import android.content.Intent
import com.example.coupangeats.src.main.home.HomeFragmentView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentFavoritesBinding
import com.example.coupangeats.databinding.FragmentHomeBinding
import com.example.coupangeats.databinding.FragmentMyeatsBinding
import com.example.coupangeats.src.main.MainActivity
import com.example.coupangeats.src.main.SubsActivity
import com.example.coupangeats.src.main.favorites.FavoritesViewModel
import com.example.coupangeats.src.main.home.HomeFragment
import com.example.coupangeats.src.main.home.models.SignUpResponse
import com.example.coupangeats.src.main.home.models.UserResponse
import com.example.coupangeats.src.main.search.SearchinputActivity


class MyeatsFragment : BaseFragment<FragmentMyeatsBinding>(FragmentMyeatsBinding::bind, R.layout.fragment_myeats),
    MyeatsFragmentView {

    private lateinit var myeatsViewModel: MyeatsViewModel
    private var _binding: FragmentMyeatsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private override val binding get() = _binding !!
    override val binding get() = _binding !!

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            var myeatsViewModel =
                ViewModelProvider(this).get(MyeatsViewModel::class.java)

            _binding = FragmentMyeatsBinding.inflate(inflater, container, false)
            val root: View = binding.root

            val textView: TextView = binding.myeatsTv
            myeatsViewModel.text.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })
            return root
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

    override fun onGetUserSuccess(response: UserResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetUserFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostSignUpFailure(message: String) {
        TODO("Not yet implemented")
    }

}


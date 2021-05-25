package com.example.coupangeats.src.main


import android.os.Bundle
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivitySubsBinding
import com.example.coupangeats.src.main.favorites.FavoritesFragment
import com.example.coupangeats.src.main.home.HomeFragment
import com.example.coupangeats.src.main.myeats.MyeatsFragment
import com.example.coupangeats.src.main.orderdetails.OrderdetailsFragment
import com.example.coupangeats.src.main.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class SubsActivity : BaseActivity<ActivitySubsBinding>(ActivitySubsBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
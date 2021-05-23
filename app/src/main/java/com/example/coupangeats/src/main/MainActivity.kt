package com.example.coupangeats.src.main


import android.os.Bundle
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMainBinding
import com.example.coupangeats.src.main.favorites.FavoritesFragment
import com.example.coupangeats.src.main.home.HomeFragment
import com.example.coupangeats.src.main.myeats.MyeatsFragment
import com.example.coupangeats.src.main.orderdetails.OrderdetailsFragment
import com.example.coupangeats.src.main.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.navView.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SearchFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_favorites -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, FavoritesFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_orderdetails -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, OrderdetailsFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_myeats -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyeatsFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            })
    }
}

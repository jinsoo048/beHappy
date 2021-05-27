package com.example.coupangeats.src.main


import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMainBinding
import com.example.coupangeats.src.main.favorites.FavoritesFragment
import com.example.coupangeats.src.main.home.HomeFragment
import com.example.coupangeats.src.main.myeats.CRUD
import com.example.coupangeats.src.main.myeats.MyeatsFragment
import com.example.coupangeats.src.main.orderdetails.OrderdetailsFragment
import com.example.coupangeats.src.main.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    var lv: ListView? = null
    var adapter: ArrayAdapter<String>? = null
    var d: Dialog? = null
    var crud = CRUD()

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

                        //login 상태 점검 후 분기
                        var login: Int = -1
                        if (login == 0){
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, MyeatsFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true

                        }else{
                            displayInputDialog(- 1)
                            return@OnNavigationItemSelectedListener true                        }
                    }
                }
                false
            })


    }
    private fun displayInputDialog(pos: Int) {

        d = this?.let { Dialog(it) }
        d !!.setTitle("Login Dialog")
        d !!.setContentView(R.layout.login_dialog)
        val maintitleIv = d !!.findViewById<View>(R.id.maintitleIv) as ImageView
        val apploginBotton = d !!.findViewById<View>(R.id.apploginBtn) as Button
        val idloginBotton = d !!.findViewById<View>(R.id.idloginBtn) as Button
        val subscriptIv = d !!.findViewById<View>(R.id.subscriptIv) as ImageView
        val lawdescIv = d !!.findViewById<View>(R.id.lawdescIv) as ImageView

        if (pos == - 1) {
            apploginBotton.isEnabled = true
            idloginBotton.isEnabled = false
            subscriptIv.isEnabled = true
        } else {
            apploginBotton.isEnabled = true
            idloginBotton.isEnabled = true
            subscriptIv.isEnabled = true
        }


        apploginBotton.setOnClickListener {

            Toast.makeText(this, "앱로그인 버튼입니다", Toast.LENGTH_SHORT).show()


        }
        idloginBotton.setOnClickListener {

            Toast.makeText(this, "쿠팡아이디 로그인입니다", Toast.LENGTH_SHORT).show()


        }
        subscriptIv.setOnClickListener { //DELETE

            val intent = Intent(this, SubsActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "회원가입 입니다.", Toast.LENGTH_SHORT).show()
        }

        d !!.show()

    }


}

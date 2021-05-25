package com.example.coupangeats.src.main.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentHomeBinding
import com.example.coupangeats.src.main.home.models.SignUpResponse
import com.example.coupangeats.src.main.home.models.UserResponse
import com.example.coupangeats.src.main.search.SearchinputActivity
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
    HomeFragmentView {


    var MyrecyclerView: RecyclerView? = null
    var MyrecyclerView2: RecyclerView? = null
    var MyrecyclerView3: RecyclerView? = null
    var MyrecyclerView4: RecyclerView? = null

    //images array
    var images : ArrayList<*> = ArrayList (
        Arrays.asList<Any>(
        R.drawable.main_pv_bunsic,
        R.drawable.main_pv_chicken,
        R.drawable.main_pv_chim,
        R.drawable.main_pv_china,
        R.drawable.main_pv_dongas,
        R.drawable.main_pv_gui,
        R.drawable.main_pv_japan,
        R.drawable.main_pv_pigleg
        )
    )

    //images2 array
    var images2 : ArrayList<*> = ArrayList (
        Arrays.asList<Any>(
            R.drawable.main_pp_food1,
            R.drawable.main_pp_food2,
            R.drawable.main_pp_food3,
            R.drawable.main_pp_food4,
        )
    )

    //images3 array
    var images3 : ArrayList<*> = ArrayList (
        Arrays.asList<Any>(
            R.drawable.main_gr_filter1,
            R.drawable.main_gr_filter2,
            R.drawable.main_gr_filter3,
            R.drawable.main_gr_filter4,
            R.drawable.main_gr_filter5,
            )
    )

    //images4 array
    var images4 : ArrayList<*> = ArrayList (
        Arrays.asList<Any>(
            R.drawable.main_gr_food1,
            R.drawable.main_gr_food2,
            R.drawable.main_gr_food3,
        )
    )



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recycler1
        MyrecyclerView = view.findViewById(R.id.mainRecyclerView) as RecyclerView ?
        val mylayoutManager: LinearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        MyrecyclerView!!.layoutManager = mylayoutManager
        val adapter = HomeRecyclerAdapter(context = HomeFragment(),images)
        MyrecyclerView!!.adapter = adapter


        //recycler2
        MyrecyclerView2 = view.findViewById(R.id.mainRecyclerView2) as RecyclerView ?
        val mylayoutManager2: LinearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        MyrecyclerView2!!.layoutManager = mylayoutManager2
        val adapter2 = HomeRecyclerAdapter(context = HomeFragment(),images2)
        MyrecyclerView2!!.adapter = adapter2

        //recycler3
        MyrecyclerView3 = view.findViewById(R.id.mainRecyclerView3) as RecyclerView ?
        val mylayoutManager3: LinearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        MyrecyclerView3!!.layoutManager = mylayoutManager3
        val adapter3 = HomeRecyclerAdapter(context = HomeFragment(),images3)
        MyrecyclerView3!!.adapter = adapter3      
        
        
        //recycler4
        MyrecyclerView4 = view.findViewById(R.id.mainRecyclerView4) as RecyclerView ?
        val mylayoutManager4: LinearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        MyrecyclerView4!!.layoutManager = mylayoutManager4
        val adapter4 = HomeRecyclerAdapter(context = HomeFragment(),images4)
        MyrecyclerView4!!.adapter = adapter4



        binding.imageView3.setOnClickListener {

            val intent = Intent(context, SearchinputActivity::class.java)
            startActivity(intent)
        }

        //binding.listView.onItemClickListener
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





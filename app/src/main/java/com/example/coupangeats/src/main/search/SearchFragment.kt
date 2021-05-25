package com.example.coupangeats.src.main.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentSearchBinding
import com.example.coupangeats.src.main.home.models.SignUpResponse
import com.example.coupangeats.src.main.home.models.UserResponse
import kotlin.collections.ArrayList


class SearchFragment() : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search),
    SearchFragmentView {

    var myRecyclerView: RecyclerView? = null

    // Using ArrayList to store images data
    private val myImageList: IntArray = intArrayOf(
        R.drawable.newone,
        R.drawable.oneperson,
        R.drawable.korean,
        R.drawable.chicken,
        R.drawable.bunsic,
        R.drawable.dongas,
        R.drawable.pigleg,
        R.drawable.chim,
        R.drawable.gui,
        R.drawable.piza,
        R.drawable.china,
        R.drawable.japan
    )
    //private ListView listView;
    private val myNameList = arrayOf(
        "네온펀치",
        "네이처",
        "레드벨벳",
        "미드나잇",
        "블랙핑크",
        "소녀시대",
        "여아아이들",
        "우아",
        "청순",
        "체리블렛",
        "프리티",
        "플레쉬"
    )

    private var foodList: ArrayList<SearchFood>? = null
    private var lv: ListView? = null
    private var searchAdapter: SearchAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        foodList = populateList()
        myRecyclerView = view.findViewById(R.id.search_Rv) as RecyclerView?

        val myStagerdGridLayoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL,)
        myRecyclerView!!.layoutManager = myStagerdGridLayoutManager

        val adapter = SearchAdapter(SearchFragment(), foodList!!)
        myRecyclerView!!.adapter = adapter

        binding.imageView3.setOnClickListener{
            val intent = Intent(context, SearchinputActivity::class.java)
            startActivity(intent)
        }

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

    private fun populateList(): ArrayList<SearchFood> {
        val list = ArrayList<SearchFood>()
        for (i in 0..11) {
            val searchfood = SearchFood()
            searchfood.foodname = myNameList[i]
            searchfood.image_drawable = myImageList[i]
            list.add(searchfood)
        }
        return list
    }

}


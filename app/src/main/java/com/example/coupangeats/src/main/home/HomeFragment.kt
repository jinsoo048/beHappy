package com.example.coupangeats.src.main.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentHomeBinding
import com.example.coupangeats.src.main.address.AddressFragment
import com.example.coupangeats.src.main.home.adpaters.*
import com.example.coupangeats.src.main.home.models.SignUpResponse
import com.example.coupangeats.src.main.home.models.storelistf.StoreList
import com.example.coupangeats.src.main.home.models.UserResponse
import com.example.coupangeats.src.main.search.SearchinputActivity
import java.util.*
import kotlin.collections.ArrayList
import com.example.coupangeats.src.main.home.models.storelistf.Result


@Suppress("UNREACHABLE_CODE")
class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
    HomeFragmentView {


    var MyrecyclerView: RecyclerView? = null
    var MyrecyclerView2: RecyclerView? = null
    var MyrecyclerView3: RecyclerView? = null
    var MyrecyclerView4: RecyclerView? = null

    //recycler item click
    //lateinit var binding: ActivityMainBinding
    lateinit var resultList: ArrayList<Result>



    //images array
    var images: ArrayList<*> = ArrayList(
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
    var images2: ArrayList<*> = ArrayList(
        Arrays.asList<Any>(
            R.drawable.main_pp_food1,
            R.drawable.main_pp_food2,
            R.drawable.main_pp_food3,
            R.drawable.main_pp_food4,
        )
    )

    //images3 array
    var images3: ArrayList<*> = ArrayList(
        Arrays.asList<Any>(
            R.drawable.main_gr_filter1,
            R.drawable.main_gr_filter2,
            R.drawable.main_gr_filter3,
            R.drawable.main_gr_filter4,
            R.drawable.main_gr_filter5,
        )
    )

    //images4 array
    var images4: ArrayList<*> = ArrayList(
        Arrays.asList<Any>(
            R.drawable.main_gr_food1,
            R.drawable.main_gr_food2,
            R.drawable.main_gr_food3,
        )
    )


    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //showLoadingDialog(requireContext())
        HomeService(this).tryGetStoreList()



        binding.viconIv.setOnClickListener {
            //val intent = Intent(context, AddressFragment::class.java)
            //startActivity(intent)
            //activity !!.supportFragmentManager.beginTransaction()
             //   .replace(R.id.homeCl,AddressFragment())
              //  .commitAllowingStateLoss()
            //return@OnNavigationItemSelectedListener true
           activity !!.supportFragmentManager.beginTransaction()
               .replace(R.id.homeCl,AddressFragment())
               .addToBackStack(null)
               .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
               .commit()
        }

        binding.imageView3.setOnClickListener {

            val intent = Intent(context, SearchinputActivity::class.java)
            startActivity(intent)
        }

/*
        binding.homeButtonTryGetJwt.setOnClickListener {
            showLoadingDialog(context!!)
            HomeService(this).tryGetUsers()
        }

        binding.homeBtnTryPostHttpMethod.setOnClickListener {
            val email = binding.homeEtId.text.toString()
            val password = binding.homeEtPw.text.toString()
            val postRequest = PostSignUpRequest(email = email, password = password,
                confirmPassword = password, nickname = "test", phoneNumber = "010-0000-0000")
            showLoadingDialog(context!!)
            HomeService(this).tryPostSignUp(postRequest)
        }
        */


        /*
        //recycler1
        MyrecyclerView = view.findViewById(R.id.mainRecyclerView) as RecyclerView?
        val mylayoutManager: LinearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        MyrecyclerView !!.layoutManager = mylayoutManager
        val adapter = HomeRecyclerAdapter(context = HomeFragment(), images)
        MyrecyclerView !!.adapter = adapter
*/

        //recycler2
        MyrecyclerView2 = view.findViewById(R.id.mainRecyclerView2) as RecyclerView?
        val mylayoutManager2: LinearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        MyrecyclerView2 !!.layoutManager = mylayoutManager2
        val adapter2 = HomeRecyclerAdapter2(context = HomeFragment(), images2)
        MyrecyclerView2 !!.adapter = adapter2

        //recycler3
        MyrecyclerView3 = view.findViewById(R.id.mainRecyclerView3) as RecyclerView?
        val mylayoutManager3: LinearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        MyrecyclerView3 !!.layoutManager = mylayoutManager3
        val adapter3 = HomeRecyclerAdapter3(context = HomeFragment(), images3)
        MyrecyclerView3 !!.adapter = adapter3


        //recycler4
        MyrecyclerView4 = view.findViewById(R.id.mainRecyclerView4) as RecyclerView?
        val mylayoutManager4: LinearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        MyrecyclerView4 !!.layoutManager = mylayoutManager4
        val adapter4 = HomeRecyclerAdapter4(context = HomeFragment(), images4)
        MyrecyclerView4 !!.adapter = adapter4

        //binding.listView.onItemClickListener
    }


    override fun onGetUserSuccess(response: UserResponse) {
        dismissLoadingDialog()
        for (User in response.result) {
            Log.d("HomeFragment", User.toString())
        }
        //binding.homeButtonTryGetJwt.text = response.message
        showCustomToast("Get JWT 성공")
    }

    override fun onGetUserFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
        //binding.homeBtnTryPostHttpMethod.text = response.message
        response.message?.let { showCustomToast(it) }
    }

    override fun onPostSignUpFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

    override fun onGetStoreSuccess(list: StoreList){
//        dismissLoadingDialog()
        //showCustomToast("오류: $message")


        var myrecyclerView : RecyclerView? = null
        //화면 받고
        myrecyclerView = binding.mainRecyclerView
        //레이아웃 메니져 받고
        val mylayoutManager: LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        myrecyclerView.layoutManager = mylayoutManager
        //데이터 받고
        val adapter = StoreListRecyclerAdapter(context = HomeFragment(), list.result)
        myrecyclerView.adapter = adapter


    }

    /*
    override fun onItemClick(item: Result, position: Int) {
        val intent = Intent(context, StoreDetailActivity::class.java)
        intent.putExtra("CARNAME", item.storeName)
        startActivity(intent)

    }
    */
}






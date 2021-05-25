package com.example.coupangeats.src.main.orderdetails

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentHomeBinding
import com.example.coupangeats.databinding.FragmentOrderdetailsBinding
import com.example.coupangeats.src.main.home.models.SignUpResponse
import com.example.coupangeats.src.main.home.models.UserResponse
import com.example.coupangeats.src.main.myeats.CRUD

class OrderdetailsFragment :
    BaseFragment<FragmentOrderdetailsBinding>(FragmentOrderdetailsBinding::bind, R.layout.fragment_orderdetails),
    OrderdetailsFragmentView {

    var lv: ListView? = null
    var adapter: ArrayAdapter<String>? = null
    var d: Dialog? = null
    var crud = CRUD()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //call a dialog
        displayInputDialog(- 1)
        /*
        binding.homeButtonTryGetJwt.setOnClickListener {
            showLoadingDialog(context!!)
            HomeService(this).tryGetUsers()
        }
        */

    }

    private fun displayInputDialog(pos: Int) {

        d = context?.let { Dialog(it) }
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
        } else {
            apploginBotton.isEnabled = true
            idloginBotton.isEnabled = true
        }


        apploginBotton.setOnClickListener {
            /*
            //GET DATA
            val name = nameEditTxt.text.toString()

            //VALIDATE
            if (name.isNotEmpty() && name != null) {
                //save
                crud.save(name)
                nameEditTxt.setText("")
                activity?.let { it1 ->
                    ArrayAdapter<String>(
                        it1,
                        android.R.layout.simple_list_item_1,
                        crud.getNames()
                    ).also { adapter = it }
                }
                lv!!.adapter = adapter
            } else {
                Toast.makeText(activity, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            }

            */
            Toast.makeText(activity, "앱로그인 버튼입니다", Toast.LENGTH_SHORT).show()


        }
        idloginBotton.setOnClickListener {
            /*
            //GET DATA
            val newName = nameEditTxt.text.toString()

            //VALIDATE
            if (newName.isNotEmpty() && newName != null) {
                //save
                if (crud.update(pos, newName)) {
                    nameEditTxt.setText(newName)
                    adapter = activity?.let { it1 ->
                        ArrayAdapter<String>(
                            it1,
                            android.R.layout.simple_list_item_1,
                            crud.getNames()
                        )
                    }
                    lv!!.adapter = adapter
                }
            } else {
                Toast.makeText(activity, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            }

             */
            Toast.makeText(activity, "쿠팡아이디 로그인입니다", Toast.LENGTH_SHORT).show()


        }
        subscriptIv.setOnClickListener { //DELETE
            /*
            if (crud.delete(pos)) {
                nameEditTxt.setText("")
                adapter = activity?.let { it1 ->
                    ArrayAdapter<String>(
                        it1,
                        android.R.layout.simple_list_item_1,
                        crud.getNames()
                    )
                }
                lv!!.adapter = adapter
            }
        }

             */
            Toast.makeText(activity, "회원가입 입니다.", Toast.LENGTH_SHORT).show()

        }

        d !!.show()

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


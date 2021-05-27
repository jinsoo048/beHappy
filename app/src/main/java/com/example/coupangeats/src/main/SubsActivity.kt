package com.example.coupangeats.src.main


import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivitySubsBinding
import com.example.coupangeats.config.*
import com.example.coupangeats.src.main.home.*



class SubsActivity : BaseActivity<ActivitySubsBinding>(ActivitySubsBinding::inflate) {

    //private var array_checkBox: ArrayList<*>? = null
    private var array_checkBox: ArrayList<CheckBox>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //가입 화면에 정보 입력
        var mSubsAllCb: CheckBox = findViewById(R.id.subsallCb)
        var mSubs2Cb: CheckBox = findViewById(R.id.subs2Cb)
        var mSubs3Cb: CheckBox = findViewById(R.id.subs3Cb)
        var mSubs4Cb: CheckBox = findViewById(R.id.subs4Cb)
        var mSubs5Cb: CheckBox = findViewById(R.id.subs5Cb)
        var mSubs6Cb: CheckBox = findViewById(R.id.subs6Cb)

        array_checkBox !!.add(mSubs2Cb)
        array_checkBox !!.add(mSubs3Cb)
        array_checkBox !!.add(mSubs4Cb)
        array_checkBox !!.add(mSubs5Cb)
        array_checkBox !!.add(mSubs6Cb)


        binding.subsallCb.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            //if the Main CheckBox is checked, check all CheckBoxs
            if (isChecked) {
                for (j in array_checkBox !!.indices) {
                    this.array_checkBox !![j].isChecked
                    Toast.makeText(applicationContext, "check all CheckBoxs", Toast.LENGTH_SHORT)
                        .show()

                }
                //Else, uncheck all CheckBoxs
            } else {
                for (j in array_checkBox !!.indices) {
                    this.array_checkBox !![j].isChecked = false
                    Toast.makeText(applicationContext, "uncheck all CheckBoxs", Toast.LENGTH_SHORT)
                        .show()

                }
            }
        })


        //var mmBtn: Button = findViewById(R.id.subsbtnBtn);
        binding.subsbtnBtn.setOnClickListener(android.view.View.OnClickListener {
            var result = "Selected Courses"
            if (mSubs2Cb.isChecked) {
                result += "\nmSubs2Cb"
            }
            if (mSubs3Cb.isChecked) {
                result += "\nmSubs3Cb"
            }
            if (mSubs4Cb.isChecked) {
                result += "\nmSubs4Cb"
            }
            if (mSubs5Cb.isChecked) {
                result += "\nmSubs5Cb"
            }
            if (mSubs6Cb.isChecked) {
                result += "\nmSubs6Cb"
            }
            Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT).show()

        }

        )

        /*
            //서버와 연동하여 가입하기
    binding.su.setOnClickListener {
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

        fun onCheckboxClicked(view: Any) {
            val checked = (view as CheckBox).isChecked
            var str = ""
            when (view.id) {
                R.id.subs2Cb -> str = if (checked) "subs_2_Cb Selected" else "subs_2_Cb Deselected"
                R.id.subs3Cb -> str = if (checked) "subs_3_Cb Selected" else "subs_3_Cb Deselected"
                R.id.subs4Cb -> str = if (checked) "subs_4_Cb Selected" else "subs_4_Cb Deselected"
                R.id.subs5Cb -> str = if (checked) "subs_5_Cb Selected" else "subs_5_Cb Deselected"
                R.id.subs6Cb -> str = if (checked) "subs_6_Cb Selected" else "subs_6_Cb Deselected"
            }
            Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
        }


    }
}
package com.example.coupangeats.src.main.myeats

import com.example.coupangeats.src.main.home.models.SignUpResponse
import com.example.coupangeats.src.main.home.models.UserResponse

interface MyeatsFragmentView {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}
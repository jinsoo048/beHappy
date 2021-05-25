package com.example.coupangeats.src.main.orderdetails

import com.example.coupangeats.src.main.home.models.SignUpResponse
import com.example.coupangeats.src.main.home.models.UserResponse

interface OrderdetailsFragmentView {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}
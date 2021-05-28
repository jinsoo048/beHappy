package com.example.coupangeats.src.main.address.models

data class AddressResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)
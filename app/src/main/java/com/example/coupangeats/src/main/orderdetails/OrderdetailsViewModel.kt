package com.example.coupangeats.src.main.orderdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderdetailsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Orderdetails Fragment"
    }
    val text: LiveData<String> = _text
}
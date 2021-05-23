package com.example.coupangeats.src.main.myeats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyeatsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Myeats Fragment"
    }
    val text: LiveData<String> = _text
}
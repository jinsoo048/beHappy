package com.example.coupangeats.src.main.myeats

import java.util.*

class CRUD {
    private val names: ArrayList<String> = ArrayList()

    fun save(name: String) {
        names.add(name)
    }

    fun getNames(): ArrayList<String> {
        return names
    }

    fun update(position: Int, newName: String): Boolean {
        return try {
            names.removeAt(position)
            names.add(position, newName)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun delete(position: Int): Boolean {
        return try {
            names.removeAt(position)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }


}
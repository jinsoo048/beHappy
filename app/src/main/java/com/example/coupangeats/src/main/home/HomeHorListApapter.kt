package com.example.coupangeats.src.main.home

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.coupangeats.R

class HomeHorListApapter: RecyclerView.Adapter<HomeHorListApapter.ViewHolder>() {
    private var context: Context? = null
    private var images: ArrayList<*>? = null

    public fun HomeHorListApapter(context: Context,image: ArrayList<*>){
        this.context = context
        this.images = images
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeHorListApapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomeHorListApapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var images: ImageView

        init {
            images = view.findViewById<View>(R.id.mainVpItem) as ImageView
        }
    }
}
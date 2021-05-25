package com.example.coupangeats.src.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import java.util.*

class HomeRecyclerAdapter     // Constructor for initialization
    (var context: HomeFragment, var images: ArrayList<*>) :
    RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflating the Layout(Instantiates list_item.xml layout file into View object)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_viewpageitem, parent, false)
        return ViewHolder(view)
    }

    // Binding data to the into specified position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TypeCast Object to int type
        val res = images[position] as Int
        holder.images.setImageResource(res)
    }

    override fun getItemCount(): Int {
        // Returns number of items currently available in Adapter
        return images.size
    }

    // Initializing the Views
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var images: ImageView
        init {
            images = view.findViewById<View>(R.id.mainVpItem) as ImageView
        }
    }
}
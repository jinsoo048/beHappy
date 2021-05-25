package com.example.coupangeats.src.main.search

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.coupangeats.R
import kotlin.collections.ArrayList

class SearchAdapter(var context: SearchFragment, var searchFood: ArrayList<SearchFood>):
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

        var mySearchFood: ArrayList<SearchFood> = searchFood
        //var listFilter: Filter? = null
        class SearchAdapter

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // Inflating the Layout(Instantiates list_item.xml layout file into View object)
            val view = LayoutInflater.from(parent.context).inflate(R.layout.search_list, parent, false)

            // Passing view to ViewHolder
            return ViewHolder(view)
        }

        // Binding data to the into specified position
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // TypeCast Object to int type
            val res = mySearchFood[position].image_drawable as Int
            val tv = mySearchFood[position].foodname as String

            holder.images.setImageResource(res)
            holder.foodname?.setText(tv)
        }

        override fun getItemCount(): Int {
            // Returns number of items currently available in Adapter
            return mySearchFood.size
        }

        // Initializing the Views
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var foodname: TextView? = null
            var images: ImageView


            init {
                images = view.findViewById<View>(R.id.searchIv) as ImageView
                //foodname = view.findViewById(R.id.foodTv) as TextView
            }
        }

    }
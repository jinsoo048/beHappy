package com.example.coupangeats.src.main.home

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.coupangeats.R

public class HomeListviewAdapter(private val context: Context, private val images: ArrayList<*>) :
    BaseAdapter() {

    class HomeListviewAdapter


    override fun getCount(): Int {
        return images.size
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

//JJF
        val pos: Int = position
        val context: Context = parent.context


        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            holder = ViewHolder()
            val inflater: LayoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.main_recycleritem4, null, false)
            holder.iv = view.findViewById<View>(R.id.mainVpItem) as ImageView
            view.tag = holder

        }
        else {
            holder = view.tag as ViewHolder
        }

        holder.iv !!.setImageResource(images[position] as Int)
        return view

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    fun remove(position: Int): Int {
        images.removeAt(position)
        notifyDataSetChanged()
        return images.size

    }

    override fun getViewTypeCount(): Int {
        return count
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    private inner class ViewHolder {
        var iv: ImageView? = null

    }

}




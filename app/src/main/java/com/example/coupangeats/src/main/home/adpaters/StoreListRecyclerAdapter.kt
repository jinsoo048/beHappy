package com.example.coupangeats.src.main.home.adpaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.src.main.home.HomeFragment
import com.example.coupangeats.src.main.home.models.storelistf.Result
import com.example.coupangeats.src.main.home.models.storelistf.StoreImage


class StoreListRecyclerAdapter     // Constructor for initialization
    (var context: HomeFragment, var result: List<Result>) :
    RecyclerView.Adapter<StoreListRecyclerAdapter.ViewHolder>() {

    //var mresult: List<Result> = result

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Inflating the Layout(Instantiates list_item.xml layout file into View object)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_recycleritem, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        // Returns number of items currently available in Adapter
        return result.size
    }

    // Initializing the Views
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(mResult: Result){
            var mstorage_ImageListTv : TextView? = null
            var mstore_nameTv : TextView? = null
            //var mdistanceTv: TextView? = null

            mstorage_ImageListTv = itemView.findViewById<View>(R.id.store_imageIv) as TextView
            mstore_nameTv = itemView.findViewById<View>(R.id.store_nameTv) as TextView

            mstorage_ImageListTv !!.setText(mResult.storeImageList[0].storeImageUrl)
            mstore_nameTv !!.setText(mResult.storeName)
            //maddressTv !!.text = mResult.detailAddress

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (result != null) {
            holder.bindItem(result[position])
        }
    }



}
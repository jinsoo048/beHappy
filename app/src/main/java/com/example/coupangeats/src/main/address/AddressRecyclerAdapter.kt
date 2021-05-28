package com.example.coupangeats.src.main.address

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.src.main.address.models.Result

class AddressRecyclerAdapter     // Constructor for initialization
    (var context: AddressFragment, var result: List<Result>) :
    RecyclerView.Adapter<AddressRecyclerAdapter.ViewHolder>() {

    //var mresult: List<Result> = result

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflating the Layout(Instantiates list_item.xml layout file into View object)
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.delivery_address, parent, false)
        return ViewHolder(view)
    }

    // Binding data to the into specified position
    //override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TypeCast Object to int type
        //val mTitle : String = result[position].title
        //val mAddress : String = result[position].detailAddress

        //mresult[position].title = result[position].title
        //mresult[position].detailAddress = result[position].detailAddress

        //holder.mtitleTv.setText(result[position].title)
        //holder.maddressTv.setText(result[position].detailAddress)

        //d("JJS", result[position].detailAddress)
    //}

    override fun getItemCount(): Int {
        // Returns number of items currently available in Adapter
        return result.size
    }


    // Initializing the Views
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //var mtitleTv : TextView? = null
        //var maddressTv: TextView? = null
        //var mresult: List<Result>? = null
        //var result: Result

        //init {
        //    result.mtitleTv = view.findViewById<View>(R.id.titleTv) as TextView?
        //    maddressTv = view.findViewById<View>(R.id.addressTv) as TextView?

        fun bindItem(mResult: Result){
            var mtitleTv : TextView? = null
            var maddressTv: TextView? = null
            mtitleTv = itemView.findViewById<View>(R.id.titleTv) as TextView?
            maddressTv = itemView.findViewById<View>(R.id.addressTv) as TextView?

            mtitleTv !!.text = mResult.title
            maddressTv !!.text = mResult.detailAddress

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (result != null) {
            holder.bindItem(result[position])
        }
    }


}
package com.example.alodoktertest.Modules.Home.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alodoktertest.R


class RcvDetailAdapter (private var imageUrlList: MutableList<String>, onImageClickListener : OnImageClickListener) : RecyclerView.Adapter<RcvDetailAdapter.ViewHolder>() {

    var mOnImageAClickListener = onImageClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcvDetailAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent, mOnImageAClickListener)
    }

    override fun getItemCount(): Int {
        return imageUrlList.size
    }

    override fun onBindViewHolder(holder: RcvDetailAdapter.ViewHolder, position: Int) {
        if(imageUrlList != null){
            val imageUrl = imageUrlList[position]
            holder.bind(imageUrl)
        }
    }

    inner class ViewHolder(inflater: LayoutInflater, parent: ViewGroup, onImageClickListener: OnImageClickListener) : View.OnClickListener,
            RecyclerView.ViewHolder(inflater.inflate(R.layout.item_detail_image, parent, false)){

        var imageView: ImageView? = null
        var mOnImageAClickListener = onImageClickListener

        init {
            itemView.setOnClickListener(this)
            imageView = itemView.findViewById(R.id.iv_rcv_detail)
         }

        fun bind(imageUrl: String) {
            Log.d("ALODOKTER", "ImageURL = $imageUrl")
            Glide.with(itemView.context)
                .load(imageUrl)
                .into(imageView!!)
        }

        override fun onClick(v: View?) {
            mOnImageAClickListener.onImageClicked(adapterPosition)
        }
    }

    interface OnImageClickListener{
        fun onImageClicked(position: Int)
    }
}
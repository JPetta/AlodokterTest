package com.example.alodoktertest.Modules.Details.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.alodoktertest.Modules.Home.Adapter.RcvDetailAdapter
import com.example.alodoktertest.Modules.Home.View.HomeFragment.Companion.IMAGES
import com.example.alodoktertest.R

class DetailActivity : AppCompatActivity(), RcvDetailAdapter.OnImageClickListener {

    lateinit var rcvDetailAdapter: RcvDetailAdapter
    lateinit var rcvDetailImage : RecyclerView
    lateinit var imageList : MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageArrayList = intent.getStringArrayListExtra(IMAGES)
        imageList = imageArrayList?.toMutableList()!!

        rcvDetailImage = findViewById(R.id.rv_image_detail)
        rcvDetailAdapter = RcvDetailAdapter(imageList,this)

        rcvDetailImage.apply {
            adapter = rcvDetailAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        PagerSnapHelper().attachToRecyclerView(rcvDetailImage)
    }

    override fun onImageClicked(position: Int) {
        TODO("Not yet implemented")
    }
}
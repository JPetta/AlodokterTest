package com.example.alodoktertest.Modules.Home.View

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alodoktertest.Modules.Details.View.DetailActivity
import com.example.alodoktertest.Modules.Home.Adapter.RcvAdapter
import com.example.alodoktertest.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(), RcvAdapter.OnImageClickListener {

    lateinit var viewHome: View
    lateinit var rcvHomeAdapter: RcvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewHome = inflater.inflate(R.layout.fragment_home, container, false)

        var imageList = mutableListOf<String>(
            "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://149366112.v2.pressablecdn.com/wp-content/uploads/2020/04/shutterstock_1037646616-scaled.jpg",
            "https://www.pethealthnetwork.com/sites/default/files/maine-coon-cat-484757920.jpg"
        )

        rcvHomeAdapter = RcvAdapter(imageList, this)

        viewHome.rcv_image.apply {
            adapter = rcvHomeAdapter
            layoutManager = LinearLayoutManager(context)
        }

        return viewHome
    }

    override fun onImageClicked(position: Int) {
        val intentDetail : Intent = Intent(context, DetailActivity::class.java)
        when(position){
            0 -> {
                val imageArrayListOne = arrayListOf<String>(
                    "https://today.tamu.edu/wp-content/uploads/2020/03/Cc-1180413342-scaled.jpg",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4vW8pEmGbG2ikIkG1zxgcptg13S14DXILLQ&usqp=CAU",
                    "https://static.toiimg.com/thumb/msid-76940605,imgsize-758247,width-800,height-600,resizemode-75/76940605.jpg"
                )
                intentDetail.putStringArrayListExtra(IMAGES, imageArrayListOne)
                startActivity(intentDetail)
            }
            1 -> {
                val imageArrayListTwo = arrayListOf<String>(
                    "https://www.cats.org.uk/media/3762/black-white-unsplash.jpg",
                    "https://images.unsplash.com/photo-1596079182809-d6958ad4d97d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTR8fGJsYWNrJTIwY2F0fGVufDB8fDB8&ixlib=rb-1.2.1&w=1000&q=80",
                    "https://images.unsplash.com/photo-1584615489955-ec0a8090ac34?ixid=MXwxMjA3fDB8MHxzZWFyY2h8Mnx8YmxhY2slMjBjYXR8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80"
                )
                intentDetail.putStringArrayListExtra(IMAGES, imageArrayListTwo)
                startActivity(intentDetail)
            }
            2 -> {
                val imageArrayListThree = arrayListOf<String>(
                    "https://images.unsplash.com/photo-1543055484-ac8fe612bf31?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTZ8fG1haW5lJTIwY29vbnxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80",
                    "https://i.pinimg.com/474x/90/35/37/903537aa3e6b1e124fe268752def9aca.jpg",
                    "https://images.unsplash.com/photo-1506755855567-92ff770e8d00?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8&w=1000&q=80"
                )
                intentDetail.putStringArrayListExtra(IMAGES, imageArrayListThree)
                startActivity(intentDetail)
            }
        }
    }

    companion object{
        val IMAGES = "IMAGES"
    }

}
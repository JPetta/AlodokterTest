package com.example.alodoktertest.Modules.Home.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.alodoktertest.R
import com.example.alodoktertest.util.savestatenav.BottomNavAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class HomeActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        initTab()

    }

    private fun initTab() {
        var pagerAdapter: BottomNavAdapter = BottomNavAdapter(supportFragmentManager)
        pagerAdapter.apply {
            addFragments(HomeFragment())
            addFragments(ProfileFragment())
        }

        viewPager.apply{
            offscreenPageLimit = 2
            adapter = pagerAdapter
        }

        tabLayout.apply{
            tabGravity = TabLayout.GRAVITY_FILL;
            tabMode = TabLayout.MODE_FIXED;
            addTab(tabLayout.newTab().setCustomView(R.layout.item_tab_home));
            addTab(tabLayout.newTab().setCustomView(R.layout.item_tab_profile));
        }

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        viewPager.currentItem = 0
                    }
                    1 -> {
                        viewPager.currentItem = 1
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        viewPager.currentItem = 0
                    }
                    1 -> {
                        viewPager.currentItem = 1
                    }
                }
            }
        })
    }
}
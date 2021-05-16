package com.cendekia.capstone.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cendekia.capstone.R
import com.cendekia.capstone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityMainBinding.viewPager.adapter = sectionPagerAdapter
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.viewPager)

        supportActionBar?.elevation = 0f
    }
}
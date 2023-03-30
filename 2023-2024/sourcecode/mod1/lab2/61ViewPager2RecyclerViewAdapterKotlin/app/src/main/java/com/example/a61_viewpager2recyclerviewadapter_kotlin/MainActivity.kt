package com.example.a61_viewpager2recyclerviewadapter_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a61_viewpager2recyclerviewadapter_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = PagerBasicAdapter()
    }
}
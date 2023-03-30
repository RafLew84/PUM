package com.example.a51_viewpager2fragmentstateadapter_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a51_viewpager2fragmentstateadapter_kotlin.databinding.ActivityMainBinding
import layout.PagerBasicAdapter

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = PagerBasicAdapter(this)
    }
}
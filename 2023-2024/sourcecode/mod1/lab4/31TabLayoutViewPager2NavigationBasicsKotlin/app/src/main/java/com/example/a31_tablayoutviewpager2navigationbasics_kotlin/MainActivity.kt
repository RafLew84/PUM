package com.example.a31_tablayoutviewpager2navigationbasics_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a31_tablayoutviewpager2navigationbasics_kotlin.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = PagerAdapter(this)

        binding.apply {
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = "Fragment ${position + 1}"
            }.attach()
        }
    }
}
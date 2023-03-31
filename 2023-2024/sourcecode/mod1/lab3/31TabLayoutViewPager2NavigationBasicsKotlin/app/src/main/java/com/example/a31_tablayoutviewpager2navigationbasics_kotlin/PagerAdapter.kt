package com.example.a31_tablayoutviewpager2navigationbasics_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

const val arg ="key"

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        val fragment = TemplateFragment()
        fragment.arguments = Bundle().apply {
            putInt(arg, position + 1)
        }

        return fragment
    }
}
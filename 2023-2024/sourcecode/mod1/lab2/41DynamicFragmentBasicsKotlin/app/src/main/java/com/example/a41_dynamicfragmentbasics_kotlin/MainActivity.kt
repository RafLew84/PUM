package com.example.a41_dynamicfragmentbasics_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a41_dynamicfragmentbasics_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view_tag, MainFragment())
            .commit()
    }
}
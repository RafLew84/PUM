package com.example.a41_parcelableserializablebasics_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a41_parcelableserializablebasics_kotlin.databinding.ActivityMainBinding

const val EXTRA_KEY = "parcel_example"
const val EXTRA_SERIALIZABLE = "serializable_example"
const val EXTRA_PARCELIZE = "parcelize_example"

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener { sendProperties() }
    }

    private fun sendProperties(){
        val intent = Intent(this, SecondActivity::class.java)
            .putExtra(EXTRA_KEY, Properties(1, 2, "String"))
            .putExtra(EXTRA_SERIALIZABLE, SerializableProperties(11, 11, "Serializable"))
            .putExtra(EXTRA_PARCELIZE, ParcelizeProperties(0, 0, "Parcelize"))
        startActivity(intent)
    }
}
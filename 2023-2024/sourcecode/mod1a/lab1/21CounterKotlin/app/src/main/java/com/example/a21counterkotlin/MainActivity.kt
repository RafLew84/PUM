package com.example.a21counterkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.a21counterkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //private val showCount: TextView by lazy{findViewById(R.id.show_count)}
    //private val increaseButton: Button by lazy { findViewById(R.id.increase_button) }
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        if (savedInstanceState != null)
            count = savedInstanceState.getInt("counter_state")

//        //showCount.text = count.toString()
//        binding.showCount.text = count.toString()
//
//        //increaseButton.setOnClickListener {
//        binding.increaseButton.setOnClickListener {
//            count++
//            //showCount.text = count.toString()
//            binding.showCount.text = count.toString()
//        }

        binding.apply {
            showCount.text = count.toString()
            increaseButton.setOnClickListener {
                count++
                binding.showCount.text = count.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter_state", count)
    }
}
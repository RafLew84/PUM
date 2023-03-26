package com.example.a31_explicitintentbasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.a31_explicitintentbasics.databinding.ActivitySecondBinding

const val EXTRA_REPLY = "com.example.a31_explicitintentbasics.REPLY"

class SecondActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        binding.textView.text = message

        binding.returnButton.setOnClickListener { returnMessage() }
    }

    private fun returnMessage() {
        setResult(
            RESULT_OK,
            Intent().apply {
                putExtra(EXTRA_REPLY,binding.editTextSecond.text.toString())
            })
        finish()
    }
}
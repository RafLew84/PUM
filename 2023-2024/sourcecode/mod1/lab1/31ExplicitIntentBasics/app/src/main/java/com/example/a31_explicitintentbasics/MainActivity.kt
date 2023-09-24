package com.example.a31_explicitintentbasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a31_explicitintentbasics.databinding.ActivityMainBinding

const val EXTRA_MESSAGE = "com.example.a31_explicitintentbasics.MESSAGE"

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.startSecondActivitybutton.setOnClickListener { startSecondActivity() }
    }

    private val secondActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result ->
        binding.textViewMain.text = result.data?.getStringExtra(EXTRA_REPLY)
    }

    private fun startSecondActivity() {
        val message = binding.editTextMain.text.toString()
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }

        secondActivityResultLauncher.launch(intent)
    }
}
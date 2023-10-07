package com.example.a51_implicitintentbasics_kotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.a51_implicitintentbasics_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.homeButton.setOnClickListener{
            val url = "http://wfia.uni.wroc.pl/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply{
                addCategory(Intent.CATEGORY_BROWSABLE)
            }

            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }
    }
}
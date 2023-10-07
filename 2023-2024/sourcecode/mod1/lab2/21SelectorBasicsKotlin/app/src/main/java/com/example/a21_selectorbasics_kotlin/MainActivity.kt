package com.example.a21_selectorbasics_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a21_selectorbasics_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val numberList = (0..50).map { it }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val numberListAdapter = NumberListAdapter(numberList)
        binding.recyclerView.adapter = numberListAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val selectionTracker = SelectionTracker.Builder(
            "numberSelection",
            binding.recyclerView,
            StableIdKeyProvider(binding.recyclerView),
            NumberItemDetailsLookup(binding.recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()
        numberListAdapter.selectionTracker = selectionTracker
    }
}
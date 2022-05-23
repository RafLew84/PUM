package pl.edu.uwr.pum.recyclerviewselectorkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val numberListAdapter = NumberListAdapter(createList())
        recyclerView.adapter = numberListAdapter
        val selectionTracker = SelectionTracker.Builder(
            "numberSelection",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            NumberItemDetailsLookup(recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()
        numberListAdapter.selectionTracker = selectionTracker
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun createList(): List<Int>{
        return (0..50).map { it }
    }
}
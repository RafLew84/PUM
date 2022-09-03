package pl.udu.uwr.pum.roombasicskotlin.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import pl.udu.uwr.pum.roombasicskotlin.R
import pl.udu.uwr.pum.roombasicskotlin.model.Word
import pl.udu.uwr.pum.roombasicskotlin.viewmodel.WordViewModel

class MainActivity : AppCompatActivity() {

    private val wordViewModel: WordViewModel by viewModels()

    private var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter(WordsComparator())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel.getAllWords.observe(this) { words ->
            words?.let { adapter.submitList(it) }
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            wordViewModel.insert(Word("word $num"))
            num++
        }
    }
}
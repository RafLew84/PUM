package pl.edu.uwr.pum.recyclerviewwordlistkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val wordList by lazy { List(50) { "word $it" } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = WordListAdapter(this@MainActivity, wordList as MutableList<String>)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}
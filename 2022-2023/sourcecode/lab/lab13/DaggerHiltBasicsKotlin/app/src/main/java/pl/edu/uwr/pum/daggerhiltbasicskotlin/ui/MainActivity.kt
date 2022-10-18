package pl.edu.uwr.pum.daggerhiltbasicskotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.edu.uwr.pum.daggerhiltbasicskotlin.R
import pl.edu.uwr.pum.daggerhiltbasicskotlin.util.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: AppViewModel by viewModels()
    private val progressBar: ProgressBar by lazy{findViewById(R.id.progressBar)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPosts()

        val textView = findViewById<TextView>(R.id.textView)

        viewModel.posts.observe(this){ response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { res ->
                        val content = StringBuilder()
                        res.forEach {
                            content
                                .append("id: ").append(it.id).append("\n")
                                .append("UserId: ").append(it.userId).append("\n")
                                .append("title: ").append(it.title).append("\n")
                                .append("body: ").append(it.content).append("\n\n")
                        }
                        textView.text = content
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { Log.e("TAG", "Error occurred: $it") }
                }
                is Resource.Loading -> showProgressBar()
            }
        }
    }

    private fun hideProgressBar(){
        progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        progressBar.visibility = View.VISIBLE
    }
}
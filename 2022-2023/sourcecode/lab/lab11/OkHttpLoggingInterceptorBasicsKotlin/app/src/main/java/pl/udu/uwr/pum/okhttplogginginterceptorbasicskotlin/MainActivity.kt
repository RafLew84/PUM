package pl.udu.uwr.pum.okhttplogginginterceptorbasicskotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)

        val service: PlaceholderService = RetrofitFactory.service
        val callPut = service.putPost(101, Post(1, "nowy", "content"))

        callPut.enqueue(object : Callback<Post?> {
            @SuppressLint("DefaultLocale")
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    val content = StringBuilder()
                    if (post != null) {
                        content.append("code: ").append(response.code()).append("\n")
                            .append("id: ").append(post.id).append("\n")
                            .append("UserId: ").append(post.userId).append("\n")
                            .append("title: ").append(post.title).append("\n")
                            .append("body: ").append(post.content).append("\n\n")
                    }
                    textView.append(content)
                } else {
                    textView.text = String.format("Code: %d", response.code())
                }
            }

            override fun onFailure(call: Call<Post?>, t: Throwable) {
                textView.text = t.message
            }
        })
    }
}
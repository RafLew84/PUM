package pl.udu.uwr.pum.retrofitbasicskotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(PlaceholderApi::class.java)

        val call: Call<List<Post>> = api.posts()

        call.enqueue(object : Callback<List<Post>> {
            @SuppressLint("DefaultLocale", "SetTextI18n")
            override fun onResponse(call: Call<List<Post>?>, response: Response<List<Post>?>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    posts?.forEach {
                        val content = StringBuilder()
                        content.append("id: ").append(it.id).append("\n")
                            .append("UserId: ").append(it.userId).append("\n")
                            .append("title: ").append(it.title).append("\n")
                            .append("body: ").append(it.title).append("\n\n")
                        textView.append(content)
                    }
                } else {
                    textView.text = "Code: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Post>?>, t: Throwable) {
                textView.text = t.message
            }
        })
    }
}
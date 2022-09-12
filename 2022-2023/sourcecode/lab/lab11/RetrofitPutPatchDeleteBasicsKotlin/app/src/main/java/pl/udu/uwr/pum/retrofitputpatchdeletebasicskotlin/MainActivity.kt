package pl.udu.uwr.pum.retrofitputpatchdeletebasicskotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import pl.udu.uwr.pum.retrofitpostbasicskotlin.Post
import pl.udu.uwr.pum.retrofiturlbasicskotlin.PlaceholderService
import pl.udu.uwr.pum.retrofiturlbasicskotlin.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        val service: PlaceholderService = RetrofitFactory.service
        val call: Call<Void> = service.deletePost(1)

        call.enqueue(object : Callback<Void> {
            @SuppressLint("DefaultLocale")
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    val content = StringBuilder()
                    content.append("code: ").append(response.code()).append("\n")
                    textView.append(content)
                } else {
                    textView.text = String.format("Code: %d", response.code())
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                textView.text = t.message
            }
        })

    }
}
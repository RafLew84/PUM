package pl.udu.uwr.pum.retrofiturlbasicskotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.function.Consumer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val param: MutableMap<String, String> = HashMap()
        param["postId"] = "1"
        param["_sort"] = "id"
        param["_order"] = "desc"

        val textView = findViewById<TextView>(R.id.textView)

        val service: PlaceholderService = RetrofitFactory.service

        val call = service.getComments("comments?postId=3")

        call.enqueue(object : Callback<List<Comment>?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<List<Comment>?>,
                response: Response<List<Comment>?>
            ) {
                if (response.isSuccessful) {
                    val comments = response.body()
                    comments?.forEach(Consumer { comment: Comment ->
                        val content = StringBuilder()
                        content.append("id: ").append(comment.id).append("\n")
                            .append("PostId: ").append(comment.postId).append("\n")
                            .append("name: ").append(comment.name).append("\n")
                            .append("email: ").append(comment.email).append("\n")
                            .append("text: ").append(comment.text).append("\n\n")
                        textView.append(content)
                    })
                } else textView.text = "Code: " + response.code()
            }

            override fun onFailure(call: Call<List<Comment>?>, t: Throwable) {
                textView.text = t.message
            }
        })
    }
}
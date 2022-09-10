package pl.udu.uwr.pum.retrofitbasicskotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(PlaceholderApi::class.java)
//        CoroutineScope(Dispatchers.Main).launch {
//            val posts = getData(api)
//            posts.forEach {
//                val content = StringBuilder()
//                content.append("id: ").append(it.id).append("\n")
//                    .append("UserId: ").append(it.userId).append("\n")
//                    .append("title: ").append(it.title).append("\n")
//                    .append("body: ").append(it.title).append("\n\n")
//                textView.append(content)
//            }
//        }

        GlobalScope.launch(Dispatchers.Main) {

            val posts = withContext(Dispatchers.IO) {
                val response = async { api.posts() }
                return@withContext response.await()
            }
            //val call = api.posts().await()
            val call = posts.await()
            call.forEach {
                val content = StringBuilder()
                content.append("id: ").append(it.id).append("\n")
                    .append("UserId: ").append(it.userId).append("\n")
                    .append("title: ").append(it.title).append("\n")
                    .append("body: ").append(it.title).append("\n\n")
                textView.append(content)
            }
        }
    }
//        val call: Call<List<Post>> = api.posts()

//        call.enqueue(object : Callback<List<Post>> {
//            @SuppressLint("DefaultLocale", "SetTextI18n")
//            override fun onResponse(call: Call<List<Post>?>, response: Response<List<Post>?>) {
//                if (response.isSuccessful) {
//                    val posts = response.body()
//                    posts?.forEach {
//                        val content = StringBuilder()
//                        content.append("id: ").append(it.id).append("\n")
//                            .append("UserId: ").append(it.userId).append("\n")
//                            .append("title: ").append(it.title).append("\n")
//                            .append("body: ").append(it.title).append("\n\n")
//                        textView.append(content)
//                    }
//                } else {
//                    textView.text = "Code: ${response.code()}"
//                }
//            }
//
//            override fun onFailure(call: Call<List<Post>?>, t: Throwable) {
//                textView.text = t.message
//            }
//        })
}

//private suspend fun getData(api: PlaceholderApi): List<Post> {
//    return withContext(Dispatchers.IO) {
//        val response = async { api.posts() }
//        val result = response.await().body()
//        return@withContext result!!
//    }
//}
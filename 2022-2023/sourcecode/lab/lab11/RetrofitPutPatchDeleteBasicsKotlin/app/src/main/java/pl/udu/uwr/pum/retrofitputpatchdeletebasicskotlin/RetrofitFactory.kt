package pl.udu.uwr.pum.retrofiturlbasicskotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private const val url = "https://jsonplaceholder.typicode.com/"

    val service: PlaceholderService by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PlaceholderService::class.java)
    }
}
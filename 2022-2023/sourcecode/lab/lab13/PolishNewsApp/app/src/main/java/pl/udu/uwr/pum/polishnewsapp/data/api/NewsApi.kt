package pl.udu.uwr.pum.polishnewsapp.data.api

import pl.udu.uwr.pum.polishnewsapp.data.dto.ArticleResponse
import pl.udu.uwr.pum.polishnewsapp.util.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {

    @Headers("X-ACCESS-KEY: $API_KEY")
    @GET("news?country=pl&language=pl")
    suspend fun getLatestNews(): ArticleResponse

    @Headers("X-ACCESS-KEY: $API_KEY")
    @GET("news?country=pl&language=pl")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("page") pageNumber: Int
    ): ArticleResponse
}
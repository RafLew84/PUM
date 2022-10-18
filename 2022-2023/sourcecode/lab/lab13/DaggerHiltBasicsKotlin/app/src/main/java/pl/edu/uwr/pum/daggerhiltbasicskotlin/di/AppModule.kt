package pl.edu.uwr.pum.daggerhiltbasicskotlin.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.edu.uwr.pum.daggerhiltbasicskotlin.data.remote.PlaceholderApi
import pl.edu.uwr.pum.daggerhiltbasicskotlin.data.repository.AppRepositoryImpl
import pl.edu.uwr.pum.daggerhiltbasicskotlin.domain.remote.AppRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePlaceholderApi(): PlaceholderApi{
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build().create(PlaceholderApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAppRepository(api: PlaceholderApi) : AppRepository{
        return AppRepositoryImpl(api)
    }
}
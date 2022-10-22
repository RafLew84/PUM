package pl.udu.uwr.pum.offlinecachingbasicskotlin.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.db.UserDatabase
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.remote.RandomApi
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.repository.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRandomApi(): RandomApi{
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://random-data-api.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build().create(RandomApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAppRepository(api: RandomApi, db: UserDatabase) : UserRepository {
        return UserRepository(api, db)
    }

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserDatabase = UserDatabase.getDatabase(app)
}
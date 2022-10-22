package pl.udu.uwr.pum.offlinecachingbasicsjava.di;

import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.db.UserDatabase;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.remote.RandomApi;
import pl.udu.uwr.pum.offlinecachingbasicsjava.data.repository.UserRepository;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    RandomApi provideRandomApi(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        return new Retrofit.Builder()
                .baseUrl("https://random-data-api.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build().create(RandomApi.class);
    }

    @Provides
    @Singleton
    UserDatabase provideUserDatabase(Application app){
        return Room.databaseBuilder(app, UserDatabase.class, "user_database_java4").build();
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(RandomApi api, UserDatabase db){
        return new UserRepository(db.userDao(), api);
    }
}

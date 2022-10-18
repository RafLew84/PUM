package pl.edu.uwr.pum.daggerhiltbasicsjava.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pl.edu.uwr.pum.daggerhiltbasicsjava.data.remote.PlaceholderApi;
import pl.edu.uwr.pum.daggerhiltbasicsjava.data.repository.AppRepositoryImpl;
import pl.edu.uwr.pum.daggerhiltbasicsjava.domain.remote.AppRepository;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    PlaceholderApi providePlaceholderApi(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build().create(PlaceholderApi.class);
    }

    @Provides
    @Singleton
    AppRepository provideRepository(PlaceholderApi api){
        return new AppRepositoryImpl(api);
    }
}

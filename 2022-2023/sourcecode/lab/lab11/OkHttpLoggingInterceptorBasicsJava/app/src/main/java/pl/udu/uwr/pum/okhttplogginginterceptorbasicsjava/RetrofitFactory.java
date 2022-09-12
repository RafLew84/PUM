package pl.udu.uwr.pum.okhttplogginginterceptorbasicsjava;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitFactory {
    private RetrofitFactory(){}

    private static volatile PlaceholderService INSTANCE;
    private final String url = "https://jsonplaceholder.typicode.com/";

    public static PlaceholderService makeService() {
        if (INSTANCE == null) {
            synchronized (RetrofitFactory.class) {
                if (INSTANCE == null) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient client = new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .build();

                    INSTANCE = new Retrofit.Builder()
                            .baseUrl("https://jsonplaceholder.typicode.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(client)
                            .build().create(PlaceholderService.class);
                }
            }
        }
        return INSTANCE;
    }
}

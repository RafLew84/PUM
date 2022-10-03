package pl.udu.uwr.pum.foodyjava.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private RetrofitInstance(){}

    private static volatile MealApi api;
    private static final String baseUrl = "https://www.themealdb.com/";

    public static MealApi getApi() {
        if (api == null) {
            synchronized (RetrofitInstance.class) {
                if (api == null) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient client = new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .build();
                    api = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(client)
                            .build().create(MealApi.class);
                }
            }
        }
        return api;
    }
}

package com.example.retrofitbasicsjava.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static volatile PlaceholderApi apiInstance;

    public static PlaceholderApi getApi() {
        if (apiInstance == null) {
            synchronized (RetrofitInstance.class) {
                if (apiInstance == null) {
                    apiInstance = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(PlaceholderApi.class);
                }
            }
        }
        return apiInstance;
    }
}

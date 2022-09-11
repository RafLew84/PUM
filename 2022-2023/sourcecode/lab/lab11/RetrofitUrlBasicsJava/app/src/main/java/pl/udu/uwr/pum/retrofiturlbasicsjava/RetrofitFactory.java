package pl.udu.uwr.pum.retrofiturlbasicsjava;

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
                    INSTANCE = new Retrofit.Builder()
                            .baseUrl("https://jsonplaceholder.typicode.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(PlaceholderService.class);
                }
            }
        }
        return INSTANCE;
    }
}

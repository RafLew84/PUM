package pl.udu.uwr.pum.foodyjava.api;

import pl.udu.uwr.pum.foodyjava.data.MealResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealApi {
    @GET("api/json/v1/1/filter.php?a=Polish")
    Call<MealResponse> getMealFromApi();

    @GET("api/json/v1/1/lookup.php?")
    Call<MealResponse> getMealById(@Query("i")String id);
}

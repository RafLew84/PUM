package pl.udu.uwr.pum.foodyjava.repository;

import android.app.Application;

import pl.udu.uwr.pum.foodyjava.api.RetrofitInstance;
import pl.udu.uwr.pum.foodyjava.data.MealResponse;
import retrofit2.Call;

public class MealRepository {

    public MealRepository(Application application) {
    }

    public Call<MealResponse> getMealFromApi(){
        return RetrofitInstance.getApi().getMealFromApi();
    }
}

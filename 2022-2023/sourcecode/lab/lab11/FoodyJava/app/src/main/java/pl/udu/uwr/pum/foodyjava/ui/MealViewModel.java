package pl.udu.uwr.pum.foodyjava.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import pl.udu.uwr.pum.foodyjava.data.MealResponse;
import pl.udu.uwr.pum.foodyjava.repository.MealRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealViewModel extends AndroidViewModel {

    private final String TAG = "MealViewModel";

    private final MealRepository repository;

    private final MutableLiveData<MealResponse> meals = new MutableLiveData<>();

    public MealViewModel(@NonNull Application application) {
        super(application);
        repository = new MealRepository(application);
    }

    public LiveData<MealResponse> getMeals() {
        return meals;
    }

    public void getMealsFromApi(){
        Call<MealResponse> responseCall = repository.getMealFromApi();

        responseCall.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                if (response.isSuccessful()){
                    MealResponse mealResponse = response.body();
                    if (mealResponse != null)
                        meals.postValue(mealResponse);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MealResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "error: " + t.getMessage() + "at " + TAG);
            }
        });
    }
}

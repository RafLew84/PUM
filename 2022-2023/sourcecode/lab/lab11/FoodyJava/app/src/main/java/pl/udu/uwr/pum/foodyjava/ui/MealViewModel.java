package pl.udu.uwr.pum.foodyjava.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pl.udu.uwr.pum.foodyjava.data.Meal;
import pl.udu.uwr.pum.foodyjava.data.MealResponse;
import pl.udu.uwr.pum.foodyjava.db.MealDatabase;
import pl.udu.uwr.pum.foodyjava.repository.MealRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealViewModel extends AndroidViewModel {

    private final String TAG = "MealViewModel";

    private final MealRepository repository;

    private final MutableLiveData<MealResponse> meals = new MutableLiveData<>();
    private final MutableLiveData<MealResponse> meal = new MutableLiveData<>();
    private LiveData<List<Meal>> favorites;

    public MealViewModel(@NonNull Application application) {
        super(application);
        repository = new MealRepository(application);
    }

    public LiveData<MealResponse> getMeals() {
        return meals;
    }

    public LiveData<MealResponse> getMeal() {
        return meal;
    }

    public LiveData<List<Meal>> getFavorites() {
        return favorites;
    }

    public void getMealById(String id){
        Call<MealResponse> responseCall = repository.getMealById(id);

        responseCall.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                if (response.isSuccessful()){
                    MealResponse mealResponse = response.body();
                    if (mealResponse != null)
                        meal.postValue(mealResponse);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MealResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "error: " + t.getMessage() + "at " + TAG);
            }
        });
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

    public void getAllMeals(){
        favorites = repository.getAllMeals();
    }

    public void insert(Meal meal){
        MealDatabase.databaseWriteExecutor.execute(() -> repository.insert(meal));
    }

    public void delete(Meal meal){
        MealDatabase.databaseWriteExecutor.execute(() -> repository.delete(meal));
    }
}

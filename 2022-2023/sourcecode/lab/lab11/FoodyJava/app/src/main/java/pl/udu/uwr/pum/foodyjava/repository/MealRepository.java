package pl.udu.uwr.pum.foodyjava.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import pl.udu.uwr.pum.foodyjava.api.RetrofitInstance;
import pl.udu.uwr.pum.foodyjava.data.Meal;
import pl.udu.uwr.pum.foodyjava.data.MealResponse;
import pl.udu.uwr.pum.foodyjava.db.MealDao;
import pl.udu.uwr.pum.foodyjava.db.MealDatabase;
import retrofit2.Call;

public class MealRepository {

    private final MealDao mealDao;

    public MealRepository(Application application) {
        MealDatabase db = MealDatabase.getDatabase(application);
        mealDao = db.mealDao();
    }

    public Call<MealResponse> getMealFromApi(){
        return RetrofitInstance.getApi().getMealFromApi();
    }

    public Call<MealResponse> getMealById(String id){
        return RetrofitInstance.getApi().getMealById(id);
    }

    public void insert(Meal meal){
        mealDao.insert(meal);
    }

    public void delete(Meal meal){
        mealDao.delete(meal);
    }

    public LiveData<List<Meal>> getAllMeals(){
        return mealDao.getAllMeals();
    }
}

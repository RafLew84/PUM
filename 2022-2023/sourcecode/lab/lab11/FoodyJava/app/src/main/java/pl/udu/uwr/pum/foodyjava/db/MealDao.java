package pl.udu.uwr.pum.foodyjava.db;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import pl.udu.uwr.pum.foodyjava.data.Meal;

@Dao
public interface MealDao {
    @Insert(onConflict = REPLACE)
    void insert(Meal meal);

    @Delete
    void delete(Meal meal);

    @Query("SELECT * FROM meals")
    LiveData<List<Meal>> getAllMeals();
}

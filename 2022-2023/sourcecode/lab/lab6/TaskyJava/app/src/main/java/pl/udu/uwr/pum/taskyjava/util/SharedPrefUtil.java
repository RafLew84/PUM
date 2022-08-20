package pl.udu.uwr.pum.taskyjava.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pl.udu.uwr.pum.taskyjava.model.Task;

final public class SharedPrefUtil {
    private SharedPrefUtil(){}

    public static final String TASK_LIST = "tasks";
    public static final String TASK_FILE = "task_file_java";

    public static void saveTaskList(Context context, List<Task> tasks){
        Gson gson = new Gson();
        String json = gson.toJson(tasks);

        SharedPreferences preferences = context.getSharedPreferences(TASK_FILE, Context.MODE_PRIVATE);
        preferences.edit().putString(TASK_LIST, json).apply();
    }

    public static ArrayList<Task> getTaskList(Context context){
        Gson gson = new Gson();
        SharedPreferences preferences = context.getSharedPreferences(TASK_FILE, Context.MODE_PRIVATE);
        String json = preferences.getString(TASK_LIST, "");
        if (json.isEmpty())
            return new ArrayList<>();

        Type type = new TypeToken<ArrayList<Task>>(){}.getType();
        return gson.fromJson(json, type);
    }
}

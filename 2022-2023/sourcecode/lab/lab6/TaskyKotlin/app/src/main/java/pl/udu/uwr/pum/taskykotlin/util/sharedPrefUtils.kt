package pl.udu.uwr.pum.taskykotlin.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import pl.udu.uwr.pum.taskykotlin.model.Task
import java.util.ArrayList

private const val TASK_LIST = "tasks"
private const val TASK_FILE = "task_file"

fun saveTaskList(context: Context, list: List<Task>) {
    val json = Gson().toJson(list)

    val sharedPreferences = context.getSharedPreferences(TASK_FILE, MODE_PRIVATE)
    sharedPreferences.edit().putString(TASK_LIST, json).apply()
}

fun getTasksList(context: Context): List<Task> {
    val sharedPreferences = context.getSharedPreferences(TASK_FILE, MODE_PRIVATE)
    val json = sharedPreferences.getString(TASK_LIST, "")

    if (json.isNullOrEmpty()) {
        return emptyList()
    }

    val type = object : TypeToken<ArrayList<Task>>() {}.type
    return Gson().fromJson(json, type)
}
package pl.udu.uwr.pum.taskyjava.data;

import java.util.ArrayList;

import pl.udu.uwr.pum.taskyjava.model.Task;
import pl.udu.uwr.pum.taskyjava.model.TaskGroup;

final public class DataProvider {
    private DataProvider(){}

    public static ArrayList<Task> getTasks(){
        ArrayList<Task> tasks = new ArrayList<>();
            tasks.add(new Task("task1", new TaskGroup("Group 1")));
            tasks.add(new Task("task2", new TaskGroup("Group 1")));
            tasks.add(new Task("task3", new TaskGroup("Group 1")));
            tasks.add(new Task("task4", new TaskGroup("Group 1")));
            tasks.add(new Task("task5", new TaskGroup("Group 1")));
            tasks.add(new Task("task a", new TaskGroup("Group 2")));
            tasks.add(new Task("task b", new TaskGroup("Group 2")));
            tasks.add(new Task("task c", new TaskGroup("Group 2")));
            tasks.add(new Task("task d", new TaskGroup("Group 2")));
            return tasks;
    }
}

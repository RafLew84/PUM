package pl.udu.uwr.pum.taskyjava.model;

public class Task {
    private final String name;
    private final TaskGroup type;

    public Task(String name, TaskGroup type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public TaskGroup getType() {
        return type;
    }
}

package pl.edu.uwr.pum.pumappjava.data;


import java.util.ArrayList;

public class Lecture {
    private final int id;
    private final String name;
    private final ArrayList<String> content;

    public Lecture(int id, String name, ArrayList<String> content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getContent() {
        return content;
    }
}

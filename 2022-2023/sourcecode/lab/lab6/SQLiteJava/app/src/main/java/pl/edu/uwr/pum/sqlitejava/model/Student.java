package pl.edu.uwr.pum.sqlitejava.model;

public class Student {
    private int id = 0;
    private String name;
    private int index;

    public Student(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public Student(int id, String name, int index) {
        this(name, index);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

package pl.edu.uwr.pum.pumappjava.data;

public class Module {
    private final int id;
    private final String name;
    private final Lecture lecture;
    private final Lab lab;
    private final App apps;

    public Module(int id, String name, Lecture lecture, Lab lab, App apps) {
        this.id = id;
        this.name = name;
        this.lecture = lecture;
        this.lab = lab;
        this.apps = apps;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public Lab getLab() {
        return lab;
    }

    public App getApps() {
        return apps;
    }
}

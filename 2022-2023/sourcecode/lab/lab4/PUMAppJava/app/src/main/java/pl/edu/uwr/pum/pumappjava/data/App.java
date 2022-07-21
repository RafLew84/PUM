package pl.edu.uwr.pum.pumappjava.data;

import java.util.ArrayList;

public class App {
    private final int id;
    private final ArrayList<String> apps;

    public App(int id, ArrayList<String> apps) {
        this.id = id;
        this.apps = apps;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getApps() {
        return apps;
    }
}

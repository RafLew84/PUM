package pl.edu.uwr.pum.pumappjava.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class DataProvider {
    private DataProvider(){}

    public static ArrayList<Module> getModules(){
        int capacity = 3;
        ArrayList<Lecture> lectures = new ArrayList<>(capacity);
        lectures.add(new Lecture(0, "Podstawowe Informacje", new ArrayList<>(Arrays.asList("podstawowe informacje", "treści programowe", "warunki zaliczenia"))));
        lectures.add(new Lecture(1, "Cykl życia aktywności", new ArrayList<>(Arrays.asList("Struktura projektu", "Activity", "Cykl życia aktywności", "Stan instancji", "Bundle", "Intent"))));
        lectures.add(new Lecture(2, "RecyclerView", new ArrayList<>(Arrays.asList("RecyclerView", "Adapter", "ViewHolder", "Selector"))));

        ArrayList<Lab> labs = new ArrayList<>(capacity);
        labs.add(new Lab(0, "Lab 1", new ArrayList<>(Arrays.asList("LinearLayout", "ConstraintLayout", "Obsługa onClick"))));
        labs.add(new Lab(1, "Lab 2", new ArrayList<>(Arrays.asList("Mechanizm intentów - jawne", "Intefejsy Serializable, Parcelable", "Mechanizm intentów - domniemane"))));
        labs.add(new Lab(2, "Lab 3", new ArrayList<>(Arrays.asList("RecyclerView", "Selector"))));

        ArrayList<App> apps = new ArrayList<>(capacity);
        apps.add(new App(0, new ArrayList<>(Collections.singletonList("CounterApp"))));
        apps.add(new App(1, new ArrayList<>(Collections.singletonList("QuizApp"))));
        apps.add(new App(2, new ArrayList<>(Arrays.asList("WFiApp", "QuickYoga"))));

        ArrayList<Module> modules = new ArrayList<>(3);
        for (int i = 0; i < capacity; i++){
            modules.add(new Module(0, "Module" + i, lectures.get(i), labs.get(i), apps.get(i)));
        }
        return modules;
    }
}

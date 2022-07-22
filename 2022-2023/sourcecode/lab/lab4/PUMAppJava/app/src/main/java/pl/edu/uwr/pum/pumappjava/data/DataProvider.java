package pl.edu.uwr.pum.pumappjava.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class DataProvider {
    private DataProvider(){}

    public static ArrayList<Module> getModules(){
        int capacity = 4;
        ArrayList<Lecture> lectures = new ArrayList<>(capacity);
        lectures.add(new Lecture(0, "Podstawowe Informacje", new ArrayList<>(Arrays.asList("podstawowe informacje", "treści programowe", "warunki zaliczenia"))));
        lectures.add(new Lecture(1, "Cykl życia aktywności", new ArrayList<>(Arrays.asList("Struktura projektu", "Activity", "Cykl życia aktywności", "Stan instancji", "Bundle", "Intent"))));
        lectures.add(new Lecture(2, "RecyclerView", new ArrayList<>(Arrays.asList("RecyclerView", "Adapter", "ViewHolder", "Selector"))));
        lectures.add(new Lecture(3, "Fragmenty", new ArrayList<>(Arrays.asList("Jetpack Navigation", "Navigation Drawer", "Fragment"))));

        ArrayList<Lab> labs = new ArrayList<>(capacity);
        labs.add(new Lab(0, "Przygotowanie layoutu", new ArrayList<>(Arrays.asList("LinearLayout", "ConstraintLayout", "Obsługa onClick"))));
        labs.add(new Lab(1, "Mechanizm intentów", new ArrayList<>(Arrays.asList("Mechanizm intentów - jawne", "Intefejsy Serializable, Parcelable", "Mechanizm intentów - domniemane"))));
        labs.add(new Lab(2, "RecyclerView", new ArrayList<>(Arrays.asList("RecyclerView", "Selector"))));
        labs.add(new Lab(3, "Nawigacja", new ArrayList<>(Arrays.asList("Fragmenty statyczne", "Fragmenty dynamiczne", "Navigation Drawer", "RecyclerView"))));

        ArrayList<App> apps = new ArrayList<>(capacity);
        apps.add(new App(0, new ArrayList<>(Collections.singletonList("CounterApp"))));
        apps.add(new App(1, new ArrayList<>(Collections.singletonList("QuizApp"))));
        apps.add(new App(2, new ArrayList<>(Arrays.asList("WFiApp", "QuickYoga"))));
        apps.add(new App(3, new ArrayList<>(Collections.singletonList("PUMApp"))));

        ArrayList<Module> modules = new ArrayList<>(3);
        for (int i = 0; i < capacity; i++){
            modules.add(new Module(0, "Module" + i, lectures.get(i), labs.get(i), apps.get(i)));
        }
        return modules;
    }
}

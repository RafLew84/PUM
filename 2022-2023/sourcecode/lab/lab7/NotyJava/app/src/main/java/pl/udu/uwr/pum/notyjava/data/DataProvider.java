package pl.udu.uwr.pum.notyjava.data;

import java.util.ArrayList;
import java.util.Arrays;

public final class DataProvider {
    private DataProvider(){}

    public static final String[] data = {"notatka 1", "notatka 2", "notatka 3", "notatka 4", "notatka 5", "notatka 6", "notatka 7", "notatka 8", "notatka 9"};

    public static ArrayList<String> dummyData = new ArrayList<>(Arrays.asList(data));
}

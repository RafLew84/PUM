package pl.udu.uwr.pum.verynobleappjava.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class Constants {
    private Constants(){}

    public enum CATEGORIES{
        PHYSICS, CHEMISTRY, LITERATURE, PEACE, ECONOMY, PHYSIOLOGYORMEDICINE
    }

    public static Map<CATEGORIES, String> categories = new TreeMap<CATEGORIES, String>(){{
        put(CATEGORIES.PHYSICS, "phy");
        put(CATEGORIES.ECONOMY, "eco");
        put(CATEGORIES.LITERATURE, "lit");
        put(CATEGORIES.PEACE, "pea");
        put(CATEGORIES.CHEMISTRY, "che");
        put(CATEGORIES.PHYSIOLOGYORMEDICINE, "med");
    }};
}

package com.example.viewmodelbasicsjava.data;

import java.util.ArrayList;
import java.util.Arrays;

public final class DataProvider {
    private DataProvider(){}

    private static String[] words = {
            "dom",
            "ojciec",
            "matka",
            "piękno",
            "ból",
            "szkoła",
            "miłość",
            "praca",
            "twarz",
            "noc",
            "dzień",
            "stół",
            "kawa",
            "pies",
            "kot",
            "dziecko",
            "prawo",
            "cisza",
            "piosenka",
            "szczęście",
            "słońce",
            "długo",
            "krótka",
            "drzewo",
            "kwiat",
            "woda",
            "noga",
            "ręka",
            "mężczyzna",
            "kobieta",
            "czas",
            "malarz",
            "muzyka",
            "kolor",
            "głowa",
            "brzuch",
            "długie",
            "krótki",
            "serce",
            "oko",
            "miska",
            "lustro",
            "słowo",
            "most",
            "szybko",
            "sklep",
            "kino",
            "dziadek",
            "babcia",
            "lampa"
    };

    public static ArrayList<String> allWordsList = new ArrayList<>(Arrays.asList(words));
}

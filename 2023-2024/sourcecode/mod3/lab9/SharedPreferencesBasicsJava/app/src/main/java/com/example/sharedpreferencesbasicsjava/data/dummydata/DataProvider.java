package com.example.sharedpreferencesbasicsjava.data.dummydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class DataProvider {

    private DataProvider(){}

    private static final List<String> usernames = new ArrayList<>();

    static {
        usernames.add("CoolDude123");
        usernames.add("SuperStar");
        usernames.add("GamerGirl99");
        usernames.add("TechMaster");
        usernames.add("MusicLover");
        usernames.add("FitnessFreak");
        usernames.add("Traveler_21");
        usernames.add("FoodieQueen");
        usernames.add("NatureLover");
        usernames.add("Fashionista");
        usernames.add("Bookworm42");
        usernames.add("MovieBuff");
        usernames.add("AdventureSeeker");
        usernames.add("PetLover_87");
        usernames.add("SportsFanatic");
        usernames.add("ArtisticSoul");
        usernames.add("StarGazer");
        usernames.add("YogaEnthusiast");
        usernames.add("PhotographyPro");
        usernames.add("DreamChaser");
        usernames.add("BeachBum123");
        usernames.add("CoffeeAddict");
        usernames.add("GameChanger");
        usernames.add("LaughOutLoud");
        usernames.add("MindfulSoul");
        usernames.add("HappyGoLucky");
        usernames.add("TechGeek1");
        usernames.add("FoodExplorer");
        usernames.add("FitnessJunkie");
    }

    public static String getUsername() {
        Random random = new Random();
        int index = random.nextInt(usernames.size());
        return usernames.get(index);
    }
}

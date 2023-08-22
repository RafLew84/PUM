package com.example.repositorybasicsjava.dummydata;


import com.example.repositorybasicsjava.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class DataProvider {

    private DataProvider(){}
    private static final List<String> firstNames = Arrays.asList(
            "Adam", "Ewa", "Jan", "Anna", "Piotr", "Maria", "Tomasz", "Małgorzata", "Krzysztof", "Alicja",
            "Andrzej", "Joanna", "Michał", "Barbara", "Kamil", "Magdalena", "Robert", "Monika", "Mateusz", "Natalia"
    );

    private static final List<String> lastNames = Arrays.asList(
            "Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Kamiński", "Lewandowski", "Zieliński", "Szymański",
            "Woźniak", "Dąbrowski", "Kozłowski", "Jankowski", "Mazur", "Kwiatkowski", "Krawczyk", "Piotrowski", "Grabowski",
            "Nowakowski", "Pawłowski"
    );

    private static final Random random = new Random();

    public static List<User> getUsers() {
        return generateUsers(41);
    }

    private static List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String firstName = getRandomElement(firstNames);
            String lastName = getRandomElement(lastNames);
            User user = new User(firstName, lastName);
            users.add(user);
        }
        return users;
    }

    private static String getRandomElement(List<String> list) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}


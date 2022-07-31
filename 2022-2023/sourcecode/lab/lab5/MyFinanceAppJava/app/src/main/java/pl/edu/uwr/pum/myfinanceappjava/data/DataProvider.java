package pl.edu.uwr.pum.myfinanceappjava.data;

import android.graphics.Color;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class DataProvider {
    private DataProvider() {}

    public static Accounts[] accounts = {
            new Accounts("Home savings", "1111111111", 23456.34, Color.BLUE),
            new Accounts("Car savings", "2222222222", 126578.99, Color.LTGRAY),
            new Accounts("Vacation", "3457733323", 9875.12, Color.MAGENTA),
            new Accounts("Emergency", "9488344443", 10000.77, Color.RED),
            new Accounts("Healthcare", "3243554434", 12345.00, Color.YELLOW),
            new Accounts("Shopping", "2947560007", 3456.56, Color.BLACK)
    };

    public static double totalAmount = Arrays
            .stream(accounts)
            .map(Accounts::getAmount)
            .collect(Collectors.toList())
            .stream()
            .mapToDouble(Double::doubleValue)
            .sum();
}

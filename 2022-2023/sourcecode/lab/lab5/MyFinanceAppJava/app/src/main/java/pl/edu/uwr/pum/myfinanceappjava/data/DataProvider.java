package pl.edu.uwr.pum.myfinanceappjava.data;

import android.graphics.Color;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public final class DataProvider {
    private DataProvider() {}

    public static Account[] accounts = {
            new Account("Home savings", "1111111111", 23456.34, Color.BLUE),
            new Account("Car savings", "2222222222", 126578.99, Color.LTGRAY),
            new Account("Vacation", "3457733323", 9875.12, Color.MAGENTA),
            new Account("Emergency", "9488344443", 10000.77, Color.RED),
            new Account("Healthcare", "3243554434", 12345.00, Color.YELLOW),
            new Account("Shopping", "2947560007", 3456.56, Color.BLACK)
    };

    public static Bill[] bills = {
            new Bill("Bank Credit", LocalDate.of(2022, 9,22), 2300.0, Color.BLACK),
            new Bill("Tuition", LocalDate.of(2023, 2,10), 1200.0, Color.BLUE),
            new Bill("Rent", LocalDate.of(2022, 8,3), 1023.87, Color.YELLOW),
            new Bill("Loan", LocalDate.of(2022, 12,22), 334.0, Color.GRAY),
            new Bill("Car Repair", LocalDate.of(2023, 1,9), 982.33, Color.WHITE),
            new Bill("Dress Loan", LocalDate.of(2023, 5,18), 243.0, Color.MAGENTA)
    };

    public static double totalAccountsAmount = Arrays
            .stream(accounts)
            .map(Account::getAmount)
            .collect(Collectors.toList())
            .stream()
            .mapToDouble(Double::doubleValue)
            .sum();

    public static double totalBillsAmount = Arrays
            .stream(bills)
            .map(Bill::getAmount)
            .collect(Collectors.toList())
            .stream()
            .mapToDouble(Double::doubleValue)
            .sum();
}

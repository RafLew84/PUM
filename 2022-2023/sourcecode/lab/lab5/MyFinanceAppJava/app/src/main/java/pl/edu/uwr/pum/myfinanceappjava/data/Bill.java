package pl.edu.uwr.pum.myfinanceappjava.data;

import java.time.LocalDate;

public class Bill {
    private final String name;
    private final LocalDate date;
    private final double amount;
    private final int color;

    public Bill(String name, LocalDate date, double amount, int color) {
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public int getColor() {
        return color;
    }
}

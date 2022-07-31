package pl.edu.uwr.pum.myfinanceappjava.data;

public class Account {
    private final String name;
    private final String number;
    private final double amount;
    private final int color;

    public Account(String name, String number, double amount, int color) {
        this.name = name;
        this.number = number;
        this.amount = amount;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public int getColor() {
        return color;
    }
}

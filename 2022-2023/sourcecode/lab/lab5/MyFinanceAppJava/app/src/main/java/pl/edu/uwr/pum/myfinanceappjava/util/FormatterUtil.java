package pl.edu.uwr.pum.myfinanceappjava.util;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public final class FormatterUtil {
    private FormatterUtil(){}

    public static NumberFormat formatter = new DecimalFormat("#,###.##");
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
}

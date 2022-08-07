package pl.udu.uwr.pum.carsyappjava.util;

import java.time.format.DateTimeFormatter;

public final class FormatterUtil {
    private FormatterUtil(){}

    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
}
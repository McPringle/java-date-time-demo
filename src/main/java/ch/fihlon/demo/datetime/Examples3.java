/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Examples3 {

    public static void main(final String[] args) {
        final Examples3 demo = new Examples3();
        System.out.println("formatSimpleDate() = " + demo.formatSimpleDate());
        System.out.println("formatMonthDayYear() = " + demo.formatMonthDayYear());
        System.out.println("parseLocalDate() = " + demo.parseLocalDate("1291-08-01"));
    }

    public String formatSimpleDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }

    public String formatMonthDayYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    public LocalDate parseLocalDate(final String dateString) {
        return LocalDate.parse(dateString);
    }
}

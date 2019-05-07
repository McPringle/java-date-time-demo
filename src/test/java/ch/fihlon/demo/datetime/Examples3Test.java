/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class Examples3Test {

    private Examples3 examples;

    @Before
    public void before() {
        examples = new Examples3();
    }

    @Test
    public void formatSimpleDate() {
        // print out for examples sake
        System.out.println(examples.formatSimpleDate());

        final StringBuilder builder = new StringBuilder();
        final LocalDate today = LocalDate.now();
        builder.append(today.getYear()).append("-");
        builder.append(formatSingleNumberWithTrailingZero(today.getMonthValue()));
        builder.append("-").append(formatSingleNumberWithTrailingZero(today.getDayOfMonth()));
        assertEquals(builder.toString(), examples.formatSimpleDate());
    }

    @Test
    public void formatMonthDayYear() {
        // print out for examples sake
        System.out.println(examples.formatMonthDayYear());

        final LocalDate today = LocalDate.now();
        final StringBuilder builder = new StringBuilder();
        builder.append(formatSingleNumberWithTrailingZero(today.getMonthValue()));
        builder.append("/").append(formatSingleNumberWithTrailingZero(today.getDayOfMonth()));
        builder.append("/").append(today.getYear());

        assertEquals(builder.toString(), examples.formatMonthDayYear());

    }

    @Test
    public void parseLocalDate() {
        assertEquals(LocalDate.of(1291, 8, 1), examples.parseLocalDate("1291-08-01"));
    }

    private String formatSingleNumberWithTrailingZero(int number) {
        final StringBuilder builder = new StringBuilder();
        if(number < 10) {
            builder.append(0);
        }
        return builder.append(number).toString();
    }
}

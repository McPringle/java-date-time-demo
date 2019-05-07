/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples2 {

    public static void main(final String[] args) {
        final Examples2 demo = new Examples2();
        System.out.println("isTomorrowAfterToday() = " + demo.isTomorrowAfterToday());
        System.out.println("getLastDayOfMonth() = " + demo.getLastDayOfMonth());
        System.out.println("howLongUntilLongestDayOfTheYear() = " + demo.howLongUntilLongestDayOfTheYear());
        System.out.println("howLongUntilNewYear() = " + demo.howLongUntilNewYear());
        System.out.println("createDateFromJavaUtilDate() = " + demo.createDateFromJavaUtilDate());
        System.out.println("lastDaysOfMonthsInYear() = " + demo.lastDaysOfMonthsInYear(2019));
    }

    public boolean isTomorrowAfterToday() {
        final LocalDate today = LocalDate.now();
        final LocalDate tomorrow = today.plusDays(1);
        return tomorrow.isAfter(today);
    }

    public DayOfWeek getLastDayOfMonth() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
    }

    // assume the longest day of every year is June 21st
    public Period howLongUntilLongestDayOfTheYear() {
        final LocalDate today = LocalDate.now();
        final LocalDate longestDay = today.with(Month.JUNE).withDayOfMonth(21);

        return Period.between(today, longestDay);
    }

    public Duration howLongUntilNewYear() {
        final ZonedDateTime dateTime = ZonedDateTime.of(
                2019, 4, 22,
                11, 42, 21, 0,
                ZoneId.of("Europe/Zurich"));
        final ZonedDateTime newYear = ZonedDateTime.of(
                2020, 1, 1,
                0, 0, 0, 0,
                ZoneId.of("America/New_York"));
        return Duration.between(dateTime, newYear);
    }

    public LocalDate createDateFromJavaUtilDate() {
        return new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public List<DayOfWeek> lastDaysOfMonthsInYear(final int year) {
        return Stream.of(Month.values())
                .map(month -> LocalDate.of(year, month, 1)
                .with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek())
                .collect(Collectors.toList());
    }
}

/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import org.junit.Before;
import org.junit.Test;

import java.time.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Examples2Test {

    private Examples2 examples;

    @Before
    public void before() {
        this.examples = new Examples2();
    }

    @Test
    public void isTomorrowAfterToday() {
        assertTrue(examples.isTomorrowAfterToday());
    }

    @Test
    public void getLastDayOfMonth() {
        final Calendar lastDayOfMonth = Calendar.getInstance();
        final int lastDateOfMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        lastDayOfMonth.set(Calendar.DATE, lastDateOfMonth);
        final int calendarDayOfWeek = lastDayOfMonth.get(Calendar.DAY_OF_WEEK);
        final int realDayOfWeek = calendarDayOfWeek > 1 ? calendarDayOfWeek - 1 : 7; // strange day of week counting of calendar class
        final DayOfWeek dayOfWeek = DayOfWeek.of(realDayOfWeek);

        assertEquals(dayOfWeek, examples.getLastDayOfMonth());
    }

    @Test
    public void howManyDaysUntilLongestDayOfTheYear() {
        final LocalDate now = LocalDate.now();
        final LocalDate longestDay = LocalDate.now().with(Month.JUNE).withDayOfMonth(21);
        final Period untilLongestDay = now.until(longestDay);
        assertEquals(untilLongestDay, examples.howLongUntilLongestDayOfTheYear());
    }

    @Test
    public void howLongUntilNewYear() {
        final Duration duration = examples.howLongUntilNewYear();

        final ZonedDateTime dateTime = ZonedDateTime.of(
                2014, 4, 22,
                11, 42, 21, 0,
                ZoneId.of("Europe/Zurich"));
        final ZonedDateTime newYear = ZonedDateTime.of(
                2015, 1, 1,
                0, 0, 0, 0,
                ZoneId.of("America/New_York"));

        assertEquals(Duration.between(dateTime, newYear), duration);
    }

    @Test
    public void createDateFromJavaUtilDate() {
        assertEquals(LocalDate.now(), examples.createDateFromJavaUtilDate());
    }

    @Test
    public void lastDaysOfMonthsInYear() {
        final List<DayOfWeek> days = examples.lastDaysOfMonthsInYear(2014);

        days.forEach(System.out::println);

        final List<DayOfWeek> answers = Arrays.asList(
                DayOfWeek.valueOf("FRIDAY"),
                DayOfWeek.valueOf("FRIDAY"),
                DayOfWeek.valueOf("MONDAY"),
                DayOfWeek.valueOf("WEDNESDAY"),
                DayOfWeek.valueOf("SATURDAY"),
                DayOfWeek.valueOf("MONDAY"),
                DayOfWeek.valueOf("THURSDAY"),
                DayOfWeek.valueOf("SUNDAY"),
                DayOfWeek.valueOf("TUESDAY"),
                DayOfWeek.valueOf("FRIDAY"),
                DayOfWeek.valueOf("SUNDAY"),
                DayOfWeek.valueOf("WEDNESDAY"));

        assertEquals(answers, days);
    }
}

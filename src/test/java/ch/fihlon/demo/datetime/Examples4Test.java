/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import static org.junit.Assert.assertEquals;

public class Examples4Test {

    private Examples4 examples;

    @Before
    public void before() {
        examples = new Examples4();
    }

    @Test
    public void getQuarterOfYear() {
        final LocalDate firstQuarterDate = LocalDate.now().with(Month.MARCH).with(TemporalAdjusters.lastDayOfMonth());
        final LocalDate secondQuarterDate = LocalDate.now().with(Month.JUNE).with(TemporalAdjusters.lastDayOfMonth());
        final LocalDate thirdQuarterDate = LocalDate.now().with(Month.SEPTEMBER).with(TemporalAdjusters.lastDayOfMonth());
        final LocalDate fourthQuarterDate = LocalDate.now().with(Month.NOVEMBER).with(TemporalAdjusters.lastDayOfMonth());

        Assert.assertEquals(Quarter.FIRST, examples.getQuarterOfYear(firstQuarterDate));
        assertEquals(Quarter.SECOND, examples.getQuarterOfYear(secondQuarterDate));
        assertEquals(Quarter.THIRD, examples.getQuarterOfYear(thirdQuarterDate));
        assertEquals(Quarter.FOURTH, examples.getQuarterOfYear(fourthQuarterDate));
    }

    @Test
    public void getNextMartinLutherKingDay() {
        final LocalDate firstJan = LocalDate.of(2014, 1, 1);
        final LocalDate onMLKDay = firstJan
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY))
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        final LocalDate afterMLKDay = onMLKDay.plusDays(1);

        final LocalDate mlkDay2014 = LocalDate.of(2014, 1, 20);
        final LocalDate mlkDay2015 = LocalDate.of(2015, 1, 19);

        assertEquals(mlkDay2014, examples.getNextMartinLutherKingDay(firstJan));
        assertEquals(mlkDay2015, examples.getNextMartinLutherKingDay(onMLKDay));
        assertEquals(mlkDay2015, examples.getNextMartinLutherKingDay(afterMLKDay));
    }
}

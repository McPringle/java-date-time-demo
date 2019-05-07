/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class Examples1Test {

    private Examples1 examples;

    @Before
    public void before() {
        examples = new Examples1();
    }

    @After
    public void after() {
        examples = null;
    }

    @Test
    public void getStNicholausDay() {
        final LocalDate stNicholausDay = examples.getStNicholasDay();
        assertEquals(2019, stNicholausDay.getYear());
        assertEquals(Month.DECEMBER, stNicholausDay.getMonth());
        assertEquals(6, stNicholausDay.getDayOfMonth());
    }

    @Test
    public void getWakeUpTime() {
        final LocalTime wakeUpTime = examples.getWakeUpTime();
        assertEquals(6, wakeUpTime.getHour());
        assertEquals(30, wakeUpTime.getMinute());
        assertEquals(0, wakeUpTime.getSecond());
    }

    @Test
    public void getMidsummer() {
        final LocalDateTime midsummer = examples.getMidsummer();
        assertEquals(2019, midsummer.getYear());
        assertEquals(Month.JUNE, midsummer.getMonth());
        assertEquals(22, midsummer.getDayOfMonth());
        assertEquals(23, midsummer.getHour());
        assertEquals(44, midsummer.getMinute());
        assertEquals(0, midsummer.getSecond());
    }

    @Test
    public void getWakeUpTimeAtStNicholausDay() {
        final LocalDateTime combined = examples.getWakeUpTimeAtStNicholausDay();
        assertEquals(2019, combined.getYear());
        assertEquals(6, combined.getDayOfMonth());
        assertEquals(Month.DECEMBER, combined.getMonth());
        assertEquals(6, combined.getHour());
        assertEquals(30, combined.getMinute());
        assertEquals(0, combined.getSecond());
    }

    @Test
    public void getLocalDate() {
        assertEquals(LocalDate.now(), examples.getLocalDate(LocalDateTime.now()));
    }

    @Test
    public void getTimeDifferenceBetweenShanghaiAndLondon() {
        // summer: 7h difference, winter: 8h difference
        final int difference = TimeZone.getDefault().inDaylightTime(new Date()) ? 7 : 8;
        assertEquals(difference, examples.getTimeDifferenceBetweenShanghaiAndLondon());
    }

}

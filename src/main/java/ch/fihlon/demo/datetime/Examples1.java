/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Examples1 {

    public static void main(final String[] args) {
        final Examples1 demo = new Examples1();
        System.out.println("getStNicholasDay() = " + demo.getStNicholasDay());
        System.out.println("getWakeUpTime() = " + demo.getWakeUpTime());
        System.out.println("getMidsummer() = " + demo.getMidsummer());
        System.out.println("getWakeUpTimeAtStNicholausDay() = " + demo.getWakeUpTimeAtStNicholausDay());
        System.out.println("getLocalDate() = " + demo.getLocalDate(demo.getMidsummer()));
        System.out.println("getTimeDifferenceBetweenShanghaiAndLondon() = " + demo.getTimeDifferenceBetweenShanghaiAndLondon());
    }

    public LocalDate getStNicholasDay() {
        return LocalDate.of(2019, Month.DECEMBER, 6);
    }

    public LocalTime getWakeUpTime() {
        return LocalTime.of(6, 30);
    }

    public LocalDateTime getMidsummer() {
        return LocalDateTime.of(2019, 6, 22, 23, 44);
    }

    public LocalDateTime getWakeUpTimeAtStNicholausDay() {
        return LocalDateTime.of(getStNicholasDay(), getWakeUpTime());
    }

    public LocalDate getLocalDate(final LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    public int getTimeDifferenceBetweenShanghaiAndLondon() {
        final ZonedDateTime shanghai = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        final ZonedDateTime london = ZonedDateTime.now(ZoneId.of("Europe/London"));
        return shanghai.getHour() - london.getHour();
    }
}

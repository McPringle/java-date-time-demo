/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import java.time.LocalDate;

public class Examples4 {

    public static void main(final String[] args) {
        final Examples4 demo = new Examples4();
        final LocalDate today = LocalDate.now();
        System.out.println("getQuarterOfYear() = " + demo.getQuarterOfYear(today));
        System.out.println("getNextMartinLutherKingDay() = " + demo.getNextMartinLutherKingDay(today));
    }

    public Quarter getQuarterOfYear(final LocalDate date) {
        final QuarterOfYearQuery quarterOfYearQuery = new QuarterOfYearQuery();
        return date.query(quarterOfYearQuery);
    }

    public LocalDate getNextMartinLutherKingDay(final LocalDate date) {
        final NextMartinLutherKingDayQuery nextMartinLutherKingDayQuery = new NextMartinLutherKingDayQuery();
        return date.query(nextMartinLutherKingDayQuery);
    }
}

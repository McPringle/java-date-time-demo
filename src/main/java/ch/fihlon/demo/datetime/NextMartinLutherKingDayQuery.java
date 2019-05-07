/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;

public class NextMartinLutherKingDayQuery implements TemporalQuery<LocalDate> {

    @Override
    public LocalDate queryFrom(final TemporalAccessor temporal) {
        final LocalDate date = LocalDate.from(temporal);
        final LocalDate currentYearMLKDay = getMartinLutherKingDayForDayInYear(date.getYear());

        final Period periodToCurrentYearMLKDay = Period.between(date, currentYearMLKDay);

        if (periodToCurrentYearMLKDay.isNegative() || periodToCurrentYearMLKDay.isZero()) {
            return getMartinLutherKingDayForDayInYear(date.getYear() + 1);
        }

        return currentYearMLKDay;
    }

    private LocalDate getMartinLutherKingDayForDayInYear(final int year) {
        return LocalDate.of(year, Month.JANUARY, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.MONDAY));
    }
}

/*
 * Copyright (C) 2014-2019 Marcus Fihlon
 */

package ch.fihlon.demo.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class QuarterOfYearQuery implements TemporalQuery<Quarter> {

    @Override
    public Quarter queryFrom(final TemporalAccessor temporal) {
        final LocalDate date = LocalDate.from(temporal);

        if (date.isBefore(date.with(Month.APRIL).withDayOfMonth(1))) {
            return Quarter.FIRST;
        } else if (date.isBefore(date.with(Month.JULY).withDayOfMonth(1))) {
            return Quarter.SECOND;
        } else if (date.isBefore(date.with(Month.OCTOBER).withDayOfMonth(1))) {
            return Quarter.THIRD;
        } else {
            return Quarter.FOURTH;
        }
    }
}

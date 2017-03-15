package org.wefine.javacore;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class PeriodExample {
    public static void main(String[] args) {

        System.out.println("Period");
        Period period = Period.of(2, 3, 0);
        System.out.println("2 years and 3 months: " + period);
        period = Period.ofYears(2);
        System.out.println("2 years: " + period);
        period = Period.ofMonths(5);
        System.out.println("5 months " + period);
        period = Period.ofWeeks(10);
        System.out.println("10 weeks: " + period);
        period = Period.ofDays(15);
        System.out.println("15 days: " + period);
        period = Period.ofDays(-15);
        System.out.println("-15 days: " + period);

        System.out.println("\nParse Period");
        period = Period.parse("P5y");
        System.out.println("5 years: " + period);
        period = Period.parse("p5y");
        System.out.println("5 years: " + period);
        period = Period.parse("P5Y");
        System.out.println("5 years: " + period);
        period = Period.parse("+P5Y");
        System.out.println("5 years: " + period);
        period = Period.parse("P+5Y");
        System.out.println("5 years: " + period);
        period = Period.parse("p-5Y");
        System.out.println("5 years: " + period);

        System.out.println("\nPeriod Between");
        LocalDate today = LocalDate.now();
        LocalDate nextYear = LocalDate.of(2017, 11, 24);
        Period periodBetween = Period.between(today, nextYear);
        System.out.println(today + " -> " + nextYear + ": " + periodBetween);

        System.out.println("\nUsing Period with Dates");
        System.out.println("Next yeart plus periodBetween: " + nextYear.plus(periodBetween));
        period = Period.ofMonths(-1);
        System.out.println("Today plus -1 month: " + today.plus(period));
        System.out.println("Today minus -1 month: " + today.minus(period));
        System.out.println("Today plus 4 weeks: " + today.plus(Period.ofWeeks(4)));
        System.out.println("Today plus 15 days: " + today.plus(Period.ofDays(15)));


        System.out.println("\nDuration");

        Duration duration = Duration.of(12, ChronoUnit.HOURS);
        System.out.println("12 Hrs: " + duration);
        duration = Duration.parse("PT4H30M");
        System.out.println("4:30 Hrs: " + duration);
        LocalTime timeNow = LocalTime.now();
        System.out.println("Time now: " + timeNow);
        System.out.println("now plus 4:30 Hrs: " + timeNow.plus(duration));

        System.out.println("\nAll Together");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime now: " + localDateTime);
        period = Period.ofYears(1);
        //System.out.println("Now plus 1 year and 4:30 Hrs: " + localDateTime.plus(period.plus(duration))); //java.time.DateTimeException: Unit must be Years, Months or Days, but was Seconds
        System.out.println("Now plus 1 year and 4:30 Hrs: " + localDateTime.plus(period).plus(duration));


    }
}
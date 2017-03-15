package org.wefine.javacore;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateExample {
    public static void main(String[] args) {

        System.out.println("Creating a LocalDate object with of method");
        LocalDate date1 = LocalDate.of(2016, 11, 24);
        LocalDate date2 = LocalDate.of(2016, Month.NOVEMBER, 24);
        System.out.println(date1);
        System.out.println(date2);

        System.out.println("\nnow and parse methods");
        LocalDate date = LocalDate.now();
        System.out.println(date);
        date = LocalDate.parse("2010-01-12");
//		date = LocalDate.parse("2010-1-12"); // java.time.format.DateTimeParseException
        System.out.println(date);

        System.out.println("\ngetter methods to query LocalDate");
        date = LocalDate.now();
        System.out.println(date);
        System.out.println("Day of month: " + date.getDayOfMonth());
        System.out.println("Day of week: " + date.getDayOfWeek());
        System.out.println("Day of year: " + date.getDayOfYear());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Month Value: " + date.getMonthValue());
        System.out.println("Year: " + date.getYear());

        System.out.println("\nisAfter and isBefore Methods");
        LocalDate lastSunday = LocalDate.of(2016, 11, 20);
        System.out.println("is today after lastSunday? " + date.isAfter(lastSunday));
        System.out.println("is today before lastSunday? " + date.isBefore(lastSunday));
        System.out.println("is today equals lastSunday? " + date.equals(lastSunday));

        System.out.println("\nminus and plus methods");
        System.out.println(date);
        System.out.println("minus days:" + date.minusDays(8));
        System.out.println("minus months:" + date.minusMonths(2));
        System.out.println("minus weeks:" + date.minusWeeks(4));
        System.out.println("minus years:" + date.minusYears(1));

        System.out.println("plus days:" + date.plusDays(8));
        System.out.println("plus months:" + date.plusMonths(2));
        System.out.println("plus weeks:" + date.plusWeeks(4));
        System.out.println("plus years:" + date.plusYears(1));
        System.out.println(date);

        date = LocalDate.now();
        System.out.println("\nwith method");
        System.out.println(date);
        System.out.println("with day of month:" + date.withDayOfMonth(1));
        System.out.println("with day of year:" + date.withDayOfYear(1));
        System.out.println("with month:" + date.withMonth(7));
        System.out.println("with year:" + date.withYear(1));


    }
}
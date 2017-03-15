package org.wefine.javacore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {

        LocalTime time = LocalTime.of(14, 10, 0);
        System.out.println("Time: " + time);
        LocalDate date = LocalDate.of(2016, 11, 24);
        System.out.println("Date: " + date);
        LocalDateTime dateTime = time.atDate(date);
        System.out.println("DateTime with time at date: " + dateTime);
        dateTime = date.atTime(time);
        System.out.println("DateTime with date at time: " + dateTime);
        dateTime = LocalDateTime.parse("2010-06-05T23:22:11");
        System.out.println("Parsed DateTime: " + dateTime);
        dateTime = LocalDateTime.now();
        System.out.println("DateTime now: " + dateTime);
        dateTime = LocalDateTime.of(2019, 6, 5, 13, 35, 59);
        System.out.println("DateTime of: " + dateTime);

    }
}
package org.wefine.javacore;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(11, 35);
        System.out.println("Time (HH:mm) " + time);
        time = LocalTime.of(22, 29, 26);
        System.out.println("Time (HH:mm:ss) " + time);
        time = LocalTime.of(0, 55, 12, 9876);
        System.out.println("Time (HH:mm:ss.SS) " + time);

//		time = LocalTime.of(120, 50); //java.time.DateTimeException Invalid value for HourOfDay
//		time = LocalTime.of(10, 70); //java.time.DateTimeException Invalid value for MinuteOfDay

        time = LocalTime.now();
        System.out.println("\nTime Now: " + time);

        System.out.println("\nMethod parse");
        time = LocalTime.parse("01:01");
        System.out.println("Parsed Time: " + time);

        System.out.println("\ngetter methods to query LocalTime");
        time = LocalTime.now();
        System.out.println(time);
        System.out.println("hour: " + time.getHour());
        System.out.println("minute: " + time.getMinute());
        System.out.println("second: " + time.getSecond());
        System.out.println("nano: " + time.getNano());

        System.out.println("\nisAfter and isBefore Methods");
        LocalTime time1 = LocalTime.of(11, 30);
        LocalTime time2 = LocalTime.of(23, 30);
        System.out.println("is " + time1 + " before than " + time2 + "? " + time1.isBefore(time2));
        System.out.println("is " + time1 + " after than " + time2 + "? " + time1.isAfter(time2));
        System.out.println("is " + time1 + " equals than " + time2 + "? " + time1.equals(time2));

        System.out.println("\nwith methods");
        time = LocalTime.now();
        System.out.println(time);
        System.out.println("with hour: " + time.withHour(9));
        System.out.println("with minute: " + time.withMinute(54));
        System.out.println("with second: " + time.withSecond(23));
        System.out.println("with nano: " + time.withNano(995));

    }
}
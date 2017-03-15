package org.wefine.javacore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        DateTimeFormatter formatter5 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        DateTimeFormatter formatter6 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter formatter7 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
//		DateTimeFormatter formatter8 = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL); // Unable to extract value: class java.time.format.DateTimePrintContext

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("DateTime: " + dateTime);
        System.out.println("Date Short: " + formatter.format(date));
        System.out.println("Date Medium: " + formatter1.format(date));
        System.out.println("Date Long: " + formatter2.format(date));
        System.out.println("Date Full: " + formatter3.format(date));
        System.out.println("Time Short: " + formatter4.format(time));
        System.out.println("Time Medium: " + formatter5.format(time));
        System.out.println("DateTime Short: " + formatter6.format(dateTime));
        System.out.println("DateTime Medium: " + formatter7.format(dateTime));
//		System.out.println("Time Full: " + formatter8.format(time)); // Unable to extract value: class java.time.format.DateTimePrintContext


        System.out.println("\nFormatters with ofPattern method");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("y");
        System.out.println("Date formatted with pattern of 'y': " + dateTimeFormatter.format(date));
        dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY");
        System.out.println("Date formatted with pattern of 'YYYY': " + dateTimeFormatter.format(date));
        dateTimeFormatter = DateTimeFormatter.ofPattern("Y M d");
        System.out.println("Date formatted with pattern of 'Y M d': " + dateTimeFormatter.format(date));
        dateTimeFormatter = DateTimeFormatter.ofPattern("H h m s");
        System.out.println("Time formatted with pattern of 'H h m s': " + dateTimeFormatter.format(time));
        dateTimeFormatter = DateTimeFormatter.ofPattern("'Time now: 'h:mm a");
        System.out.println("Time formatted with pattern of 'Time now: h:mm a': " + dateTimeFormatter.format(time));
        dateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        System.out.println("Date formatted with pattern of 'yy-MM-dd': " + dateTimeFormatter.format(date));
        dateTimeFormatter = DateTimeFormatter.ofPattern("y-MM-dd");
        System.out.println("Date formatted with pattern of 'y-MM-dd': " + dateTimeFormatter.format(date));

    }
}
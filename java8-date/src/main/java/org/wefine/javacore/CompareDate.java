package org.wefine.javacore;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompareDate {

    public static void main(String[] args) {
        LocalDateTime dt0 = LocalDateTime.of(2017, 3, 30, 0, 0);

        LocalDateTime dt1 = LocalDateTime.of(2017, 3, 30, 9, 30);
        LocalDateTime dt2 = LocalDateTime.of(2017, 3, 30, 9, 50);
        LocalDateTime dt3 = LocalDateTime.of(2017, 3, 30, 11, 11);
        LocalDateTime dt4 = LocalDateTime.of(2017, 3, 30, 13, 13);
        LocalDateTime dt5 = LocalDateTime.of(2017, 3, 30, 20, 20);
        LocalDateTime dt6 = LocalDateTime.of(2017, 3, 30, 21, 30);

        long between = ChronoUnit.HOURS.between(dt1, dt2);
        System.out.println(between);

        List<LocalDateTime> list = new ArrayList<>();
        list.add(dt1);
        list.add(dt2);
        list.add(dt3);
        list.add(dt4);
        list.add(dt5);
        list.add(dt6);

        Map<Long, List<LocalDateTime>> listMap = list.stream().collect(Collectors.groupingBy(dt -> ChronoUnit.HOURS.between(dt0, dt)));
        System.out.println(listMap);
    }


}

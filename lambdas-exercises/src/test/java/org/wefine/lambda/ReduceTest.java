package org.wefine.lambda;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ReduceTest {
    Stream<String> wordStream;

    @Before
    public void before() {
        List<String> list = new ArrayList<>();

        list.add("java");
        list.add("php");
        list.add("python");
        list.add("perl");
        list.add("c");
        list.add("lisp");
        list.add("c#");

        wordStream = list.stream();
    }

    /**
     * 所有单词的长度计算。
     */
    @Test
    public void testSum1() {
        int sum = wordStream
                .map(String::length)
                .mapToInt(Integer::new)
                .sum();

        assertEquals(24, sum);
    }

    @Test
    public void testSum2() {
        int sum = wordStream
                .mapToInt(String::length)
                .sum();

        assertEquals(24, sum);
    }

    @Test
    public void testSum3() {
        int sum = wordStream
                .mapToInt(String::length)
                .reduce((x, y) -> x + y)
                .orElse(0);

        assertEquals(24, sum);
    }

    @Test
    public void testSum4() {
        int sum = wordStream
                .mapToInt(String::length)
                .reduce(Integer::sum)
                .orElse(0);

        assertEquals(24, sum);
    }

    @Test
    public void testSum5() {
        // combiner.apply(u, accumulator.apply(identity, t)) == accumulator.apply(u, t)
        int sum = wordStream.reduce(
                // identity - identity value for the combiner function
                0,
                // accumulator - function for combining two results
                (x, y) -> {
                    System.out.println(x);
                    System.out.println("y=" + y);
                    return x + y.length();
                },
                // combiner - function for adding an additional element into a result
                (x, y) -> x + y
        );

        assertEquals(24, sum);
    }

    @Test
    public void testReduce3Param() {
        String[] strArray = {"abc", "mno", "xyz"};
        List<String> strList = Arrays.asList(strArray);

        System.out.println("stream test");
        int streamResult = strList.stream().reduce(
                0,
                (total, s) -> {
                    System.out.println("accumulator: total[" + total + "] s[" + s + "] s.codePointAt(0)[" + s.codePointAt(0) + "]");
                    return total + s.codePointAt(0);
                },
                (a, b) -> {
                    System.out.println("combiner: a[" + a + "] b[" + b + "]");
                    return 1000000;
                }
        );
        System.out.println("streamResult: " + streamResult);

        System.out.println("parallelStream test");
        int parallelStreamResult = strList.parallelStream().reduce(
                0,
                (total, s) -> {
                    System.out.println("accumulator: total[" + total + "] s[" + s + "] s.codePointAt(0)[" + s.codePointAt(0) + "]");
                    return total + s.codePointAt(0);
                },
                (a, b) -> {
                    System.out.println("combiner: a[" + a + "] b[" + b + "]");
                    return 1000000;
                }
        );
        System.out.println("parallelStreamResult: " + parallelStreamResult);

        System.out.println("parallelStream test2");
        int parallelStreamResult2 = strList.parallelStream().reduce(
                0,
                (total, s) -> {
                    System.out.println("accumulator: total[" + total + "] s[" + s + "] s.codePointAt(0)[" + s.codePointAt(0) + "]");
                    return total + s.codePointAt(0);
                },
                (a, b) -> {
                    System.out.println("combiner: a[" + a + "] b[" + b + "] a+b[" + (a + b) + "]");
                    return a + b;
                }
        );
        System.out.println("parallelStreamResult2: " + parallelStreamResult2);
    }
}

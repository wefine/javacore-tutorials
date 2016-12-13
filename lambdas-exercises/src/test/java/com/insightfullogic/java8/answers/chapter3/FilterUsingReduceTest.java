package com.insightfullogic.java8.answers.chapter3;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FilterUsingReduceTest {

    @Test
    public void emptyList() {
        assertFiltered(x -> false, Collections.emptyList(), Collections.emptyList());
    }

    @Test
    public void trueReturnsEverything() {
        assertFiltered((Integer x) -> true, asList(1, 2, 3), asList(1, 2, 3));
    }

    @Test
    public void falseRemovesEverything() {
        assertFiltered((Integer x) -> false, asList(1, 2, 3), Collections.emptyList());
    }

    @Test
    public void filterPartOfList() {
        assertFiltered((Integer x) -> x > 2, asList(1, 2, 3), Collections.singletonList(3));
    }

    /**
     * @param predicate      断言
     * @param input          输入
     * @param expectedOutput 期望的结果
     * @param <I>            目标类型
     */
    private <I> void assertFiltered(Predicate<I> predicate, List<I> input, List<I> expectedOutput) {
        List<I> output = FilterUsingReduce.filter(input.stream(), predicate);
        assertEquals(expectedOutput, output);

        List<I> parallelOutput = FilterUsingReduce.filter(input.parallelStream(), predicate);
        assertEquals(expectedOutput, parallelOutput);
    }

}

package com.insightfullogic.java8.examples.chapter6;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class IntegerSum {

    private static final int size = Integer.getInteger("sum.size", 1000000);
    public int[] array;
    public List<Integer> arrayList;
    public LinkedList<Integer> linkedList;
    public TreeSet<Integer> treeSet;
    public HashSet<Integer> hashSet;

    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {
                ".*IntegerSum.*",
                "-wi",
                "10",
                "-i",
                "20",
                "-f",
                "1"
        };
        Main.main(args);
    }

    @Setup
    public void createDataSources() {
        array = IntStream.range(0, size).toArray();
        arrayList = numbers().collect(toList());
        linkedList = new LinkedList<>(arrayList);
        treeSet = new TreeSet<>(arrayList);
        hashSet = new HashSet<>(arrayList);
    }

    private Stream<Integer> numbers() {
        return IntStream.range(0, size).mapToObj(i -> i);
    }

    @Benchmark
    public int range() {
        return IntStream.range(0, size).parallel().sum();
    }

    @Benchmark
    public int serialRange() {
        return IntStream.range(0, size).sum();
    }

    @Benchmark
    public int array() {
        return IntStream.of(array).parallel().sum();
    }


    @Benchmark
    public int arrayList() {
        return arrayList.parallelStream().mapToInt(i -> i).sum();
    }

    // BEGIN addIntegers
    private int addIntegers(List<Integer> values) {
        return values.parallelStream()
                .mapToInt(i -> i)
                .sum();
    }
    // END addIntegers

    @Benchmark
    public int linkedList() {
        return linkedList.parallelStream().mapToInt(i -> i).sum();
    }

    @Benchmark
    public int treeSet() {
        return treeSet.parallelStream().mapToInt(i -> i).sum();
    }

    @Benchmark
    public int hashSet() {
        return hashSet.parallelStream().mapToInt(i -> i).sum();
    }

    @Benchmark
    public int serialArray() {
        return IntStream.of(array).sum();
    }

    @Benchmark
    public int serialArrayList() {
        return arrayList.stream().mapToInt(i -> i).sum();
    }

    @Benchmark
    public int serialLinkedList() {
        return linkedList.stream().mapToInt(i -> i).sum();
    }

    @Benchmark
    public int serialTreeSet() {
        return treeSet.stream().mapToInt(i -> i).sum();
    }

    @Benchmark
    public int serialHashSet() {
        return hashSet.stream().mapToInt(i -> i).sum();
    }

}

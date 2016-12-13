package com.insightfullogic.java8.examples.chapter2;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author richard
 */
public class LambdaExpressions {

    @Test
    public void first_lambda_1() {
        JButton button = new JButton();
        // 老式的匿名内部类的写法
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("button clicked");
            }
        });
    }

    @Test
    public void first_lambda_2() {
        JButton button = new JButton();
        // Java8 中引入的 lambda
        button.addActionListener(event -> System.out.println("button clicked"));
    }

    @Test
    public void first_lambda_3() {
        JButton button = new JButton();
        // 如果只有一行代码，花括号是可以去掉的
        button.addActionListener((ActionEvent event) -> {
            System.out.println("button clicked");
        });
    }

    @Test
    public void allLambdaForms() {
        // 多个示例
        Runnable noArguments = () -> System.out.println("Hello World"); // <1>

        ActionListener oneArgument = event -> System.out.println("button clicked"); // <2>

        Runnable multiStatement = () -> { // <3>
            System.out.print("Hello");
            System.out.println(" World");
        };

        BinaryOperator<Long> add = (x, y) -> x + y; // <4>

        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y; // <5>
    }

    @Test
    public void first_lambda_5() {
        JButton button = new JButton();
        // 在表达式中引用的变量，是要实际 final 的。
        final String name = getUserName();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("hi " + name);
            }
        });
    }

    @Test
    public void first_lambda_6() {
        JButton button = new JButton();
        // 可以不用显示地写 final
        String name = getUserName();
        button.addActionListener(event -> System.out.println("hi " + name));
    }

    @Test
    public void diamondInference() {
        // 菱形类型推断
        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>(); // <1>
        Map<String, Integer> diamondWordCounts = new HashMap<>(); // <2>
    }

    @Test
    public void diamondInferenceMethod() {
        useHashMap(new HashMap<>());
    }

    private void useHashMap(Map<String, String> values) {
        System.out.println(values);
    }

    @Test
    public void firstBiFunction() {
        // 参数有明确的数据类型
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        Object rtn = add.apply(1, 2);

        Assert.assertEquals(3, rtn);
    }

    @Test
    public void typeInferenceExamples2() {
        // 参数类型推断
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        Object rtn = addLongs.apply(1L, 2L);

        Assert.assertEquals(3L, rtn);
    }

    @Test
    public void typeInferenceExamples() {
        Predicate<Integer> atLeast5 = x -> x > 5;

        Assert.assertFalse(atLeast5.test(3));
    }

    @Test
    public void mostSpecific() {
        // 方法重载测试
        overloadedMethod("abc");
    }

    // 重载测试
    private void overloadedMethod(Object o) {
        System.out.print("Object, " + o.toString());
    }

    private void overloadedMethod(String s) {
        System.out.print("String, " + s);
    }

    @Test
    public void mostSpecificBiFunction() {
        overloadedMethod((x, y) -> x + y);
    }

    private void overloadedMethod(BinaryOperator<Integer> lambda) {
        System.out.print("BinaryOperator");
    }

    private void overloadedMethod(IntegerBiFunction lambda) {
        System.out.print("IntegerBinaryOperator");
    }

    private String getUserName() {
        return "Richard";
    }

    private interface IntegerBiFunction extends BinaryOperator<Integer> {

    }

}

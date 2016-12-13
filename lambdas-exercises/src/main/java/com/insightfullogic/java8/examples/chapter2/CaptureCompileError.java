package com.insightfullogic.java8.examples.chapter2;

import javax.swing.*;

public class CaptureCompileError {

    private JButton button;

    public void error() {
        String name = getUserName();
        name = formatUserName(name);

        // 取消下行注释的话会导致编译错误，因为表达式中引用的变量要求实质上是 final 的。
        // button.addActionListener(event -> System.out.println("hi " + name));
    }

    private String formatUserName(String name) {
        return name.toLowerCase();
    }

    private String getUserName() {
        return "RICHARD";
    }
}

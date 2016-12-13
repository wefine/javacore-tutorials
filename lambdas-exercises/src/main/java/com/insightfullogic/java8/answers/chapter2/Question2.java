package com.insightfullogic.java8.answers.chapter2;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class Question2 {

    final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(
            () -> new DateFormatter(new SimpleDateFormat("yyyy-MM-dd"))
    );

}

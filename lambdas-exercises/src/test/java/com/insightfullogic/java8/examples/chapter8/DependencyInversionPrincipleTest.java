package com.insightfullogic.java8.examples.chapter8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

import static com.insightfullogic.java8.examples.chapter8.DependencyInversionPrinciple.HeadingFinder;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DependencyInversionPrincipleTest {


    private final HeadingFinder finder;

    public DependencyInversionPrincipleTest(HeadingFinder finder) {
        this.finder = finder;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{new DependencyInversionPrinciple.NoDIP()}, {new DependencyInversionPrinciple.ExtractedDIP()}};
        return asList(data);
    }

    @Test
    public void correctHeadings() {
        InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("test_file"));
        List<String> headings = finder.findHeadings(reader);
        assertEquals(asList("Improve Content", "Cleanup", "Add Content", "Add to Streams Chapter"), headings);
    }

}

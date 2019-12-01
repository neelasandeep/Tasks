package com.epam.annotation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class StringsortTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                         { "abc", "abc" },
                         { "abc", "abc" },
         };
    }

    @Test
    @UseDataProvider("data")
    public void testSort(final String input, final String expected) {
       assertEquals(expected, input);
    }
}
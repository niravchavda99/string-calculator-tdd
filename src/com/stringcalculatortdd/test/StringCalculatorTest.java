package com.stringcalculatortdd.test;

import com.stringcalculatortdd.main.StringCalculator;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

@Test
public class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeTest
    public void init() {
        calculator = new StringCalculator();
    }

    // Test for empty string
    public void returnsZeroForEmptyString() {
        AssertJUnit.assertEquals(0, calculator.Add(""));
    }
}

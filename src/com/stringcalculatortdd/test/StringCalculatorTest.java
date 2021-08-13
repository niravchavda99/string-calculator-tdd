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

    public void singleNumberReturnsItself() {
        AssertJUnit.assertEquals(1, calculator.Add("1"));
        AssertJUnit.assertEquals(2, calculator.Add("2"));
        AssertJUnit.assertEquals(7, calculator.Add("7"));
    }
}

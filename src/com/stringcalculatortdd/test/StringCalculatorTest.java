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

    // Test for single number input
    public void singleNumberReturnsItself() {
        AssertJUnit.assertEquals(1, calculator.Add("1"));
        AssertJUnit.assertEquals(2, calculator.Add("2"));
        AssertJUnit.assertEquals(7, calculator.Add("7"));
    }

    // Test for two comma seperated number input
    public void twoNumbersSeperatedByCommaReturnsSum() {
        AssertJUnit.assertEquals(3, calculator.Add("1,2"));
        AssertJUnit.assertEquals(9, calculator.Add("4,5"));
    }

    // Test for multiple comma seperated number input
    public void multipleNumbersSeperatedByCommaReturnsSum() {
        AssertJUnit.assertEquals(3, calculator.Add("1,2"));
        AssertJUnit.assertEquals(15, calculator.Add("4,5,6"));
        AssertJUnit.assertEquals(10, calculator.Add("1,2,3,4"));
    }

    // Test for comma & newline seperated number input
    public void numbersSeperatedByCommaAndNewlineReturnsSum() {
        AssertJUnit.assertEquals(6, calculator.Add("1\n2,3"));
        AssertJUnit.assertEquals(15, calculator.Add("4,5\n6"));
        AssertJUnit.assertEquals(10, calculator.Add("1\n2\n3\n4"));
    }

    // Test for custom delimiters
    public void numbersSeperatedByCustomDelimitersReturnsSum() {
        AssertJUnit.assertEquals(3, calculator.Add("//;\n1;2"));
        AssertJUnit.assertEquals(15, calculator.Add("//;\n4;5;6"));
        AssertJUnit.assertEquals(15, calculator.Add("//?\n4?5?6"));
    }
}

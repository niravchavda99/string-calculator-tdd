package com.stringcalculatortdd.test;

import com.stringcalculatortdd.main.NegativeNumberException;
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
    public void returnsZeroForEmptyString() throws NegativeNumberException {
        AssertJUnit.assertEquals(0, calculator.Add(""));
    }

    // Test for single number input
    public void singleNumberReturnsItself() throws NegativeNumberException {
        AssertJUnit.assertEquals(1, calculator.Add("1"));
        AssertJUnit.assertEquals(2, calculator.Add("2"));
        AssertJUnit.assertEquals(7, calculator.Add("7"));
    }

    // Test for two comma seperated number input
    public void twoNumbersSeperatedByCommaReturnsSum() throws NegativeNumberException {
        AssertJUnit.assertEquals(3, calculator.Add("1,2"));
        AssertJUnit.assertEquals(9, calculator.Add("4,5"));
    }

    // Test for multiple comma seperated number input
    public void multipleNumbersSeperatedByCommaReturnsSum() throws NegativeNumberException {
        AssertJUnit.assertEquals(3, calculator.Add("1,2"));
        AssertJUnit.assertEquals(15, calculator.Add("4,5,6"));
        AssertJUnit.assertEquals(10, calculator.Add("1,2,3,4"));
    }

    // Test for comma & newline seperated number input
    public void numbersSeperatedByCommaAndNewlineReturnsSum() throws NegativeNumberException {
        AssertJUnit.assertEquals(6, calculator.Add("1\n2,3"));
        AssertJUnit.assertEquals(15, calculator.Add("4,5\n6"));
        AssertJUnit.assertEquals(10, calculator.Add("1\n2\n3\n4"));
    }

    // Test for custom delimiters
    public void numbersSeperatedByCustomDelimitersReturnsSum() throws NegativeNumberException {
        AssertJUnit.assertEquals(3, calculator.Add("//;\n1;2"));
        AssertJUnit.assertEquals(15, calculator.Add("//;\n4;5;6"));
        AssertJUnit.assertEquals(15, calculator.Add("//:\n4:5:6"));
    }

    // Test for negative numbers
    @Test(expectedExceptions = NegativeNumberException.class)
    public void negativeNumberThrowsException() throws NegativeNumberException {
        calculator.Add("-5");
        calculator.Add("1,-5");
        calculator.Add("1,5,-9");
    }

    // Test for getting called count
    public void getCalledCountReturnsCount() throws NegativeNumberException {
        StringCalculator calci = new StringCalculator();
        calci.Add("5");
        calci.Add("1,5");
        calci.Add("1,5,9");

        AssertJUnit.assertEquals(3, calci.getCalledCount());
    }

    // Test for numbers greater than 1000
    public void numbersGreaterThan1000AreIgnored() throws NegativeNumberException {
        AssertJUnit.assertEquals(2, calculator.Add("//;\n1001;2"));
        AssertJUnit.assertEquals(10, calculator.Add("//;\n4;1005;6"));
        AssertJUnit.assertEquals(9, calculator.Add("//:\n4:5:1185"));
    }

    // Test for multiple length delimiters
    public void numbersSeperatedByMultipleLengthDelimitersReturnsSum() throws NegativeNumberException {
        AssertJUnit.assertEquals(6, calculator.Add("//[***]\n1***2***3"));
    }

    // Test for multiple single-length delimiters
    public void numbersSeperatedByMultipleSingleLengthDelimitersReturnsSum() throws NegativeNumberException {
        AssertJUnit.assertEquals(6, calculator.Add("//[*][%]\n1*2%3"));
    }

    // Test for multiple multiple-length delimiters
    public void numbersSeperatedByMultipleMultipleDelimitersReturnsSum() throws NegativeNumberException {
        AssertJUnit.assertEquals(6, calculator.Add("//[**][%%]\n1**2%%3"));
    }
}

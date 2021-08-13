package com.stringcalculatortdd.main;

import java.util.ArrayList;

public class StringCalculator {
    private String delimiters = "[,\n]";
    private static int calledCount = 0;

    private boolean isTextEmpty(String numbers) {
        return numbers.isEmpty();
    }

    private int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    private int calculateSum(String... numbers) throws NegativeNumberException {
        checkNegativeNumbers(numbers);

        int sum = 0;

        for(String number : numbers) {
            if(isNumeric(number)) {
                int num = convertToInteger(number);
                if(num <= 1000)
                    sum += num;
            }
        }

        return sum;
    }

    private boolean isNumeric(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void setDelimiters(String numbers) {
        if(isTextEmpty(numbers)) delimiters = "[,\n]";
        if(numbers.startsWith("//")) {
            String customDelimiter = numbers.substring(2, 3);
            delimiters = "[" + customDelimiter + "\n]";
        } else {
            delimiters = "[,\n]";
        }
    }

    private void checkNegativeNumbers(String... numbers) throws NegativeNumberException {
        ArrayList<String> negativeNumbers = new ArrayList<>();

        for(String number : numbers)
            if(isNumeric(number) && convertToInteger(number) < 0) negativeNumbers.add(number);

        if(!negativeNumbers.isEmpty())  {
            throw new NegativeNumberException("Cannot have negative numbers!\nFound: " + negativeNumbers.toString());
        }
    }

    public int Add(String numbers) throws NegativeNumberException {
        ++calledCount;

        if(isTextEmpty(numbers))
            return 0;

        setDelimiters(numbers);
        String[] numberList = numbers.split(delimiters);

        if(numbers.length() == 1)
            return convertToInteger(numbers);
        else
            return calculateSum(numberList);
    }

    public int getCalledCount() {
        return calledCount;
    }
}

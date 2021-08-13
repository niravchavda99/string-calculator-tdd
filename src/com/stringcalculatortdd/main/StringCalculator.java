package com.stringcalculatortdd.main;

public class StringCalculator {
    private boolean isTextEmpty(String numbers) {
        return numbers.isEmpty();
    }

    private int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    private int calculateSum(String... numbers) {
        int sum = 0;

        for(String number : numbers)
            sum += convertToInteger(number);

        return sum;
    }

    public int Add(String numbers) {
        String[] numberList = numbers.split(",");

        if(isTextEmpty(numbers))
            return 0;
        if(numbers.length() == 1)
            return convertToInteger(numbers);
        else
            return calculateSum(numberList);
    }
}

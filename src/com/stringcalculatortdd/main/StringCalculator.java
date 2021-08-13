package com.stringcalculatortdd.main;

public class StringCalculator {
    private boolean isTextEmpty(String numbers) {
        return numbers.isEmpty();
    }

    private int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    public int Add(String numbers) {
        if(isTextEmpty(numbers))
            return 0;
        return convertToInteger(numbers);
    }
}

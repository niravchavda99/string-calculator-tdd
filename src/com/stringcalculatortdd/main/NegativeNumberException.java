package com.stringcalculatortdd.main;

public class NegativeNumberException extends Exception {
    String message;

    public NegativeNumberException(String message) {
        super(message);
    }

    public NegativeNumberException() {
        super("Negative numbers not allowed!");
    }
}


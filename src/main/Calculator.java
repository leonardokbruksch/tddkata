package main;

public class Calculator {
    public int sum(int value1, int value2) {
        return value1 + value2;
    }

    public int subtract(int value1, int value2) {
        return value1 - value2;
    }

    public int divide(int value1, int value2) {
        if(value2 == 0){
            throw new IllegalArgumentException("Cannot divide by zero.");
        } else {
            return value1 / value2;
        }
    }

    public int multiply(int value1, int value2) {
        return value1 * value2;
    }
}

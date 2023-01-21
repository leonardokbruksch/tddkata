package test;

import main.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {

    @Test
    public void testSimpleSum(){
        Calculator calculator = new Calculator();
        int result = calculator.sum(1 , 1);
        int expectedValue = 2;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testBigSum(){
        Calculator calculator = new Calculator();
        int result = calculator.sum(43 , 7);
        int expectedValue = 50;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testSubtraction(){
        Calculator calculator = new Calculator();
        int result = calculator.subtract(2 , 1);
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testBigSubtraction(){
        Calculator calculator = new Calculator();
        int result = calculator.subtract(80 , 40);
        int expectedValue = 40;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testNegativeSubtraction(){
        Calculator calculator = new Calculator();
        int result = calculator.subtract(3 , 5);
        int expectedValue = -2;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testDoubleNegativeSubtraction(){
        Calculator calculator = new Calculator();
        int result = calculator.subtract(-3 , -2);
        int expectedValue = -1;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testMultiply(){
        Calculator calculator = new Calculator();
        int result = calculator.multiply(4 , 2);
        int expectedValue = 8;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testBigMultiply(){
        Calculator calculator = new Calculator();
        int result = calculator.multiply(50 , 4);
        int expectedValue = 200;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testMultiplyByZero(){
        Calculator calculator = new Calculator();
        int result = calculator.multiply(50 , 0);
        int expectedValue = 0;
        Assert.assertEquals(expectedValue, result);

        result = calculator.multiply(0 , 50);
        expectedValue = 0;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testDivision(){
        Calculator calculator = new Calculator();
        int result = calculator.divide(4 , 2);
        int expectedValue = 2;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testBigDivision(){
        Calculator calculator = new Calculator();
        int result = calculator.divide(1000 , 10);
        int expectedValue = 100;
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void testDividedByZero(){
        Calculator calculator = new Calculator();

        IllegalArgumentException exception = Assert.assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));

        Assert.assertEquals(exception.getMessage(), "Cannot divide by zero.");

    }


}

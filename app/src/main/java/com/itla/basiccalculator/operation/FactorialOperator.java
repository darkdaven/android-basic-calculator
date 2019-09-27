package com.itla.basiccalculator.operation;

public class FactorialOperator implements MathOperation {
    @Override
    public Double calc(Double firstValue, Double secondValue) {
        if(firstValue.intValue() == 0)
            return 1d;

        Integer factorial = 1;

        for(int i = 1; i <= firstValue.intValue(); i++) {
            factorial *= i;
        }

        return factorial.doubleValue();
    }
}

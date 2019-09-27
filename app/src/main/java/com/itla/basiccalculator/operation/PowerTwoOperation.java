package com.itla.basiccalculator.operation;

public class PowerTwoOperation implements MathOperation {
    @Override
    public Double calc(Double firstValue, Double secondValue) {
        return Math.pow(firstValue, 2);
    }
}

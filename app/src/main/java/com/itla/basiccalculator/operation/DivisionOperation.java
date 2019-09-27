package com.itla.basiccalculator.operation;

public class DivisionOperation implements MathOperation {
    @Override
    public Double calc(Double firstValue, Double secondValue) {
        return firstValue / secondValue;
    }
}

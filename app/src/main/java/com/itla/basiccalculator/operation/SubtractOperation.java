package com.itla.basiccalculator.operation;

public class SubtractOperation implements MathOperation {
    @Override
    public Double calc(Double firstValue, Double secondValue) {
        return firstValue - secondValue;
    }
}

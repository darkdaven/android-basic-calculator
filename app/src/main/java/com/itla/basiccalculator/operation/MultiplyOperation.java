package com.itla.basiccalculator.operation;

public class MultiplyOperation implements MathOperation {
    @Override
    public Double calc(Double firstValue, Double secondValue) {
        return firstValue * secondValue;
    }
}

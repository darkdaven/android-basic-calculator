package com.itla.basiccalculator.operation;

public class SquareRootOperator implements MathOperation {
    @Override
    public Double calc(Double firstValue, Double secondValue) {
        return Math.sqrt(firstValue);
    }
}

package com.itla.basiccalculator.operation;

public class PercentOperation implements MathOperation {
    @Override
    public Double calc(Double firstValue, Double secondValue) {
        return firstValue / 100d;
    }
}

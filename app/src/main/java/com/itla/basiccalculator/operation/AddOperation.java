package com.itla.basiccalculator.operation;

public class AddOperation implements MathOperation {
    @Override
    public Double calc(Double firstValue, Double secondValue) {
        return firstValue + secondValue;
    }
}

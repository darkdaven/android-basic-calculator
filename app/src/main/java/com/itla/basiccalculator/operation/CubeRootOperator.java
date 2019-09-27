package com.itla.basiccalculator.operation;

public class CubeRootOperator implements MathOperation {
    @Override
    public Double calc(Double firstValue, Double secondValue) {
        return Math.cbrt(firstValue);
    }
}

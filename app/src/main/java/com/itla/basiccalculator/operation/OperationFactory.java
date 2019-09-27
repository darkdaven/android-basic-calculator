package com.itla.basiccalculator.operation;

import java.security.InvalidParameterException;

public class OperationFactory {
    private final static OperationFactory instance = new OperationFactory();

    private OperationFactory() {
    }

    public static OperationFactory getInstance() {
        return instance;
    }

    public MathOperation getOperation(Operator operator) {
        switch (operator) {
            case ADD:
                return new AddOperation();
            case SUBTRACT:
                return new SubtractOperation();
            case DIVISION:
                return new DivisionOperation();
            case MULTIPLY:
                return new MultiplyOperation();
            case PERCENT:
                return new PercentOperation();
            case CUBE_ROOT:
                return new CubeRootOperator();
            case FACTORIAL:
                return new FactorialOperator();
            case SQUARE_ROOT:
                return new SquareRootOperator();
            case POWER_TWO:
                return new PowerTwoOperation();
            default:
                throw new InvalidParameterException();
        }
    }
}

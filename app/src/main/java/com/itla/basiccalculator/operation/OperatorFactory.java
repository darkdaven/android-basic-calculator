package com.itla.basiccalculator.operation;

import java.security.InvalidParameterException;

public class OperatorFactory {

    public static Operator getOperatorBySymbol(String symbol) {
        switch (symbol) {
            case "+":
                return Operator.ADD;
            case "-":
                return Operator.SUBTRACT;
            case "/":
                return Operator.DIVISION;
            case "x":
                return Operator.MULTIPLY;
            case "%":
                return Operator.PERCENT;
            case "√":
                return Operator.SQUARE_ROOT;
            case "x!":
                return Operator.FACTORIAL;
            case "3√":
                return Operator.CUBE_ROOT;
            case "x**2":
                return Operator.POWER_TWO;
            default:
                throw new InvalidParameterException(String.format("Symbol %s is invalid", symbol));
        }
    }
}

package com.itla.basiccalculator.operation;

public enum Operator {
    ADD("+", false),
    SUBTRACT("-", false),
    DIVISION("/", false),
    MULTIPLY("x", false),
    PERCENT("%", true),
    SQUARE_ROOT("√", true),
    FACTORIAL("x!", true),
    CUBE_ROOT("3√", true),
    POWER_TWO("x**2", true);

    private String symbol;
    private Boolean immediately;

    Operator(String symbol, Boolean immediately) {
        this.symbol = symbol;
        this.immediately = immediately;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Boolean getImmediately() {
        return this.immediately;
    }
}

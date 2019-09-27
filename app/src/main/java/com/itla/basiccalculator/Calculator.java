package com.itla.basiccalculator;

import com.itla.basiccalculator.operation.MathOperation;
import com.itla.basiccalculator.operation.OperationFactory;
import com.itla.basiccalculator.operation.Operator;
import com.itla.basiccalculator.operation.OperatorFactory;

public class Calculator {
    private Double holdValue = Double.NaN;
    private Operator operator;

    public void makeCalculation(String operatorSymbol, Double currentValue) {
        Operator operator = OperatorFactory.getOperatorBySymbol(operatorSymbol);

        if(this.holdValue.isNaN()) {
            this.holdValue = currentValue;
            this.operator = operator;

            if (operator.getImmediately()) {
                final MathOperation operation = OperationFactory.getInstance().getOperation(this.operator);
                this.holdValue = operation.calc(holdValue, currentValue);
            }

        } else {
            final MathOperation operation = OperationFactory.getInstance().getOperation(this.operator);
            this.holdValue =  operation.calc(holdValue, currentValue);
            this.operator = operator;
        }
    }

    public Double getValue(final Double currentValue) {
        if(this.operator == null)
            return currentValue;

        final MathOperation operation = OperationFactory.getInstance().getOperation(this.operator);
        final Double value = operation.calc(holdValue, currentValue);
        this.clear();
        return value;
    }

    public Double getValue() {
        return this.holdValue;
    }

    public void clear() {
        this.holdValue = Double.NaN;
        this.operator = null;
    }
}

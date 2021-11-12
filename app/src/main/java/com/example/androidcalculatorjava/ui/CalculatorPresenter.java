package com.example.androidcalculatorjava.ui;

import com.example.androidcalculatorjava.domain.Calculator;
import com.example.androidcalculatorjava.domain.Operation;

public class CalculatorPresenter {

    private final CalculatorView view;
    private final Calculator calculator;
    private Double argOne = 0.0;
    private Double argTwo = 0.0;
    private Double result = 0.0;
    private Operation operation = Operation.EMPTY;
    private static final int BASE = 10;
    private boolean isDotPress = false;
    private int divider;


    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(int digit) {
        if (operation == Operation.EMPTY) {
            if (isDotPress) {
                argOne = argOne + digit / (double) divider;
                divider *= BASE;
            } else {
                argOne = argOne * BASE + digit;
            }
        } else {
            if (isDotPress) {
                argTwo = argTwo + digit / (double) divider;
                divider *= BASE;
            } else {
                argTwo = argTwo * BASE + digit;
            }
        }
        view.showResultWithoutEquals();
    }

    public void onOperationPressed(Operation operation) {
        this.operation = operation;
        isDotPress = false;
        view.showResult();
    }

    public void onDotPressed() {
        if (!isDotPress) {
            isDotPress = true;
            divider = BASE;
        }
    }

    public void displayResult() {
        result = calculator.performOperation(argOne, argTwo, operation);
        view.showResult();
        argOne = result;
        argTwo = 0.0;
        result = 0.0;
    }

    public void displayClear() {
        argOne = 0.0;
        argTwo = 0.0;
        result = 0.0;
        operation = Operation.EMPTY;
        isDotPress = false;
        view.showResult();
    }

    public Double getResult() {
        return result;
    }

    public Double getArgOne() {
        return argOne;
    }

    public Double getArgTwo() {
        return argTwo;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setArgOne(Double argOne) {
        this.argOne = argOne;
    }

    public void setArgTwo(Double argTwo) {
        this.argTwo = argTwo;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}

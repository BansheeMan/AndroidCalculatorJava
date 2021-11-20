package com.example.androidcalculatorjava.domain;


public class CalculatorImp implements Calculator {

    @Override
    public double performOperation(double argOne, double argTwo, Operation operation) {
        switch (operation) {
            case PLUS:
                return argOne + argTwo;
            case MULTIPLICATION:
                return argOne * argTwo;
            case DIVISION:
                return argOne / argTwo;
            case DEDUCT:
                return argOne - argTwo;
        }
        return 0.0;
    }
}

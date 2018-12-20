package com.iopo.calculator;

public interface ICalculatorEngine {

    double calculate(String expression, String desiredOutput);
    double convertNumber(double myNumber, String desiredUnit);
}

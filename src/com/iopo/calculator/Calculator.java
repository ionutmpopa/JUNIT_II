package com.iopo.calculator;

import com.iopo.annotations.MonitoredTimeProcessor;
import java.lang.reflect.Proxy;

public class Calculator {

    public static void main(String[] args) {

        MonitoredTimeProcessor myAnnotationHandler = new MonitoredTimeProcessor(new CalculatorEngine());

        ICalculatorEngine proxiedCalculator
                = (ICalculatorEngine) Proxy.newProxyInstance(CalculatorEngine.class.getClassLoader(),
                new Class[]{ICalculatorEngine.class}, myAnnotationHandler);

        double result = proxiedCalculator.calculate("10 cm + 1 m - 10 mm", "mm");

        proxiedCalculator.convertNumber(100.00, "cm");

        System.out.println(result);

    }
}

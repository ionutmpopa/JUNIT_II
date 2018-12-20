package com.iopo.annotations;

import com.iopo.calculator.ICalculatorEngine;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class MonitoredTimeProcessor implements InvocationHandler {

    private static final Logger LOGGER = Logger.getLogger(MonitoredTimeProcessor.class.getName());
    private ICalculatorEngine calculator;

    public MonitoredTimeProcessor(ICalculatorEngine calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method m = calculator.getClass()
                .getMethod(method.getName(), method.getParameterTypes());
        boolean needsMeasurement = false;
        for (Annotation ann : m.getDeclaredAnnotations()) {
            if (ann.annotationType().equals(MonitoredTime.class) && m.getAnnotation(MonitoredTime.class).measureTimeSpent()) {
                needsMeasurement = true;
                break;
            }
        }

        if (needsMeasurement) {
            long start = System.currentTimeMillis();
            try {
                return method.invoke(calculator, args);

            } finally {
                System.out.println();
                LOGGER.info(method.getName() +
                        " -- " + (System.currentTimeMillis() - start) + " ms");
            }
        }
        return method.invoke(calculator, args);

    }
}

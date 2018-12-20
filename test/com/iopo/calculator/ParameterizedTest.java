package com.iopo.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {


    private static final String MY_UNIT = "mm";
    private static CalculatorEngine calculatorEngine = new CalculatorEngine();

    private String expression;
    private String unitOfMeasurement;
    private double expected;

    @Parameterized.Parameters
    public static List<Object> data() {
        return Arrays.asList(new Object[][] {
                {"10 cm + 1 m - 10 mm", MY_UNIT, 1090.0},
                {"10 cm + 2 m - 10 mm", MY_UNIT, 2090.0},
                {"10 cm + 3 m - 10 mm", MY_UNIT, 3090.0},
                {"10 cm + 4 m - 10 mm", MY_UNIT, 4090.0},
                {"10 cm + 5 m - 10 mm", MY_UNIT, 5090.0},
                {"10 cm + 6 m - 10 mm", MY_UNIT, 6090.0},
        });
    }

    public ParameterizedTest(String expression, String unitOfMeasurement, double expected) {
        this.expression = expression;
        this.unitOfMeasurement = unitOfMeasurement;
        this.expected = expected;
    }

    @Test
    public void testCalculateBasedOnExpression() {

        calculatorEngine.calculate(expression, MY_UNIT);
        assertEquals(calculatorEngine.getResult(), expected);
    }

}

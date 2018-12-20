package com.iopo.calculator;


import org.junit.*;
import static junit.framework.Assert.assertEquals;


public class CalculatorTest {

    private CalculatorEngine myCalculator;

    @Before
    public void setup() {
        System.out.println("in setup");
        myCalculator = new CalculatorEngine();
    }

    @Test
    public void testWhenCalculateReturnValue() {
        myCalculator.calculate("10 cm + 1 m - 10 mm", "mm");
        assertEquals(1090.0, myCalculator.getResult());
    }

    @Test
    public void testWhenCalculateReturnValueTwo() {
        myCalculator.calculate("1 cm + 1 m - 1 mm", "mm");
        assertEquals(1009.0, myCalculator.getResult());
    }

    @Test
    public void testWhenCalculateReturnValueThree() {
        myCalculator.calculate("100 cm + 1 m - 100 mm", "mm");
        assertEquals(1900.0, myCalculator.getResult());
    }

    @Test
    public void testWhenConvertValueBasedOnUnitMeasure() {
        double getValue = myCalculator.convertNumber(10.00, "cm");
        assertEquals(100.0, getValue);
    }

    @Test
    public void testWhenConvertValueBasedOnUnitMeasureTwo() {
        double getValue = myCalculator.convertNumber(100.00, "m");
        assertEquals(100000.0, getValue);
    }

    @Test
    public void testWhenApplyAdditionOrSubtraction() {

        double getValue = myCalculator.applyOp('+',10.00, 9.00);
        assertEquals(19.0, getValue);
    }

    @Test
    public void testWhenApplyAdditionOrSubtractionTwo() {

        double getValue = myCalculator.applyOp('-',10.00, 9.00);
        assertEquals(1.0, getValue);
    }

}

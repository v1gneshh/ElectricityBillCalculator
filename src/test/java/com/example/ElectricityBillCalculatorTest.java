
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElectricityBillCalculatorTest {

    ElectricityBillCalculator obj =
            new ElectricityBillCalculator();

    @Test
    public void testZeroUnits() {
        assertEquals(0.0, obj.calculateBill(0), 0.001);
    }

    @Test
    public void testFirstSlab() {
        assertEquals(75.0, obj.calculateBill(50), 0.001);
    }

    @Test
    public void testFirstSlabBoundary() {
        assertEquals(150.0, obj.calculateBill(100), 0.001);
    }

    @Test
    public void testSecondSlab() {
        assertEquals(275.0, obj.calculateBill(150), 0.001);
    }

    @Test
    public void testSecondSlabBoundary() {
        assertEquals(400.0, obj.calculateBill(200), 0.001);
    }

    @Test
    public void testThirdSlab() {
        assertEquals(600.0, obj.calculateBill(250), 0.001);
    }

    @Test
    public void testThirdSlabBoundary() {
        assertEquals(1600.0, obj.calculateBill(500), 0.001);
    }

    @Test
    public void testAbove500Units() {
        assertEquals(1900.0, obj.calculateBill(550), 0.001);
    }

    @Test
    public void testNegativeUnits() {
        assertThrows(IllegalArgumentException.class,
                () -> obj.calculateBill(-10));
    }
}
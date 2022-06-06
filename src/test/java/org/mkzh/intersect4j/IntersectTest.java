package org.mkzh.intersect4j;

import org.junit.jupiter.api.Test;
import org.mkzh.intersect4j.util.Intersect;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntersectTest {
    @Test
    public void testStandard() {
        assertEquals(new Intersect(BigDecimal.ZERO, BigDecimal.ZERO), IntersectFinder.find("x", "-x", -10, 10));
    }

    @Test
    public void testLogarithmicCustomPrecision() {
        assertEquals(new Intersect(BigDecimal.valueOf(1.5315844), BigDecimal.valueOf(0.42630275)), IntersectFinder.find("1/x^2", "ln(x)", 1, 10, 8));
    }

    @Test
    public void testTrigonometry() {
        assertEquals(new Intersect(BigDecimal.valueOf(-2.554196), BigDecimal.valueOf(-0.55419595)), IntersectFinder.find("sin(x)", "x+2", -10, 10));
    }

    @Test
    public void testDoubleIntersectOnlyFindsOne() {
        assertEquals(new Intersect(BigDecimal.valueOf(-1), BigDecimal.valueOf(1)), IntersectFinder.find("x^2", "x+2", -10, 10));
    }
}

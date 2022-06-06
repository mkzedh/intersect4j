package org.mkzh.intersect4j;

import org.mkzh.intersect4j.method.FindIntersect;
import org.mkzh.intersect4j.util.Intersect;

import java.math.BigDecimal;
import java.math.MathContext;

public class IntersectFinder {
    private static final int DEFAULT_PRECISION = 8;
    private static final int SUPPLEMENTARY_FACTOR = 2;

    public static Intersect find(String func1, String func2, double min, double max) {
        return find(func1, func2, min, max, DEFAULT_PRECISION);
    }
    public static Intersect find(String func1, String func2, double min, double max, int precision) {
        return find(func1, func2, BigDecimal.valueOf(min), BigDecimal.valueOf(max), precision);
    }
    public static Intersect find(String func1, String func2, BigDecimal min, BigDecimal max) {
        return find(func1, func2, min, max, DEFAULT_PRECISION);
    }
    public static Intersect find(String func1, String func2, BigDecimal min, BigDecimal max, int precision) {
        return FindIntersect.find(func1, func2, min, max, new MathContext(precision), new MathContext(precision * SUPPLEMENTARY_FACTOR));
    }
}

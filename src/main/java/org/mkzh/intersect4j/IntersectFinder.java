package org.mkzh.intersect4j;

import org.mkzh.intersect4j.method.FindIntersect;
import org.mkzh.intersect4j.util.Intersect;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class IntersectFinder {
    private static final int DEFAULT_DEPTH = 64;

    public static Intersect find(String func1, String func2, double min, double max) {
        return find(func1, func2, min, max, DEFAULT_DEPTH);
    }
    public static Intersect find(String func1, String func2, double min, double max, int depth) {
        return find(func1, func2, BigDecimal.valueOf(min), BigDecimal.valueOf(max), depth);
    }
    public static Intersect find(String func1, String func2, BigDecimal min, BigDecimal max) {
        return find(func1, func2, min, max, DEFAULT_DEPTH);
    }

    public static Intersect find(String func1, String func2, BigDecimal min, BigDecimal max, int depth) {
        return FindIntersect.find(func1, func2, min, max, new MathContext(depth), 1).get(0);
    }
}

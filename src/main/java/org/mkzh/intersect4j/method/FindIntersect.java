package org.mkzh.intersect4j.method;

import org.mkzh.intersect4j.util.Intersect;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.List;

public class FindIntersect {
    public static List<Intersect> find(String func1, String func2, BigDecimal min, BigDecimal max, MathContext mathContext, int numIntersects) {
        switch (numIntersects) {
            case 1:
                return Arrays.asList(findOne(func1, func2, min, max, mathContext));
        }
        return null;
    }

    private static Intersect findOne(String func1, String func2, BigDecimal min, BigDecimal max, MathContext mathContext) {
        return null;
    }
}

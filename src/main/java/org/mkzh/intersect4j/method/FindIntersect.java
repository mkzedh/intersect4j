package org.mkzh.intersect4j.method;

import com.udojava.evalex.Expression;
import com.udojava.evalex.ExpressionSettings;
import org.mkzh.intersect4j.util.Function;
import org.mkzh.intersect4j.util.Intersect;

import java.math.BigDecimal;
import java.math.MathContext;

public class FindIntersect {
    public static Intersect find(String func1, String func2, BigDecimal min, BigDecimal max, MathContext mathContext, MathContext suppContext) {
        // check if min is greater than max, if so, swap min and max
        boolean minGreaterThanMax = min.compareTo(max) > 0;
        BigDecimal rangeMin = minGreaterThanMax ? max : min;
        BigDecimal rangeMax = minGreaterThanMax ? min : max;

        return findSingleIntersect(func1, func2, rangeMin, rangeMax, mathContext, suppContext);
    }

    private static Intersect findSingleIntersect(String func1, String func2, BigDecimal min, BigDecimal max, MathContext mathContext, MathContext suppContext) {
        // set precision
        ExpressionSettings settings = Function.getFunctionSettings(suppContext);

        // calculate functions at min and max
        Expression funcExpr1 = Function.getFunctionExpression(func1, settings);
        Expression funcExpr2 = Function.getFunctionExpression(func2, settings);
        BigDecimal func1Min = Function.substituteInFunction(funcExpr1, min);
        BigDecimal func2Min = Function.substituteInFunction(funcExpr2, min);

        int minComp = func1Min.compareTo(func2Min);
        // check for cases where min is the intersect
        if (minComp == 0) {
            return new Intersect(min, func1Min);
        }

        // determine which is the larger function at min
        Expression smallerFuncAtMin;
        Expression largerFuncAtMin;
        if (minComp < 0) {
            smallerFuncAtMin = funcExpr1;
            largerFuncAtMin = funcExpr2;
        } else {
            smallerFuncAtMin = funcExpr2;
            largerFuncAtMin = funcExpr1;
        }

        BigDecimal left = min;
        BigDecimal right = max;
        while (left.compareTo(right) <= 0) {
            BigDecimal mid = left.add(right).divide(BigDecimal.valueOf(2), suppContext);
            BigDecimal valS = Function.substituteInFunction(smallerFuncAtMin, mid);
            BigDecimal valL = Function.substituteInFunction(largerFuncAtMin, mid);
            int comp = Function.compareFuncValues(valS, valL, mathContext);

            // return result if intersect found
            if (comp == 0) {
                return Intersect.getIntersectResult(mid, valS, mathContext);
            }

            if (comp < 0) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return null;
    }
}

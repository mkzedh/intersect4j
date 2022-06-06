package org.mkzh.intersect4j.util;

import com.udojava.evalex.Expression;
import com.udojava.evalex.ExpressionSettings;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;

public class Function {
    public static Expression getFunctionExpression(String func, ExpressionSettings settings) {
        return new Expression(replaceMathForEvalEx(func), settings);
    }

    public static ExpressionSettings getFunctionSettings(MathContext mathContext) {
        return ExpressionSettings.builder().mathContext(mathContext).build();
    }

    public static BigDecimal substituteInFunction(Expression expr, BigDecimal value) {
        return expr.with("x", value.toPlainString()).eval();
    }

    public static int compareFuncValues(BigDecimal val1, BigDecimal val2, MathContext mathContext) {
        return val1.round(mathContext).compareTo(val2.round(mathContext));
    }

    private static String replaceMathForEvalEx(String expression) {
        return StringUtils.replaceEach(expression,
                new String[]{
                        "sin",
                        "cos",
                        "tan",
                        "cot",
                        "sec",
                        "csc",
                        "asin",
                        "acos",
                        "atan",
                        "acot",
                        "asec",
                        "acsc",
                        "ln",
                },
                new String[]{
                        "sinr",
                        "cosr",
                        "tanr",
                        "cotr",
                        "secr",
                        "cscr",
                        "asinr",
                        "acosr",
                        "atanr",
                        "acotr",
                        "asecr",
                        "acscr",
                        "log",
                }
        );
    }
}

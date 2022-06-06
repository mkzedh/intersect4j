package org.mkzh.intersect4j.util;

import java.math.BigDecimal;
import java.math.MathContext;

public class Intersect {
    private BigDecimal x;
    private BigDecimal fx;

    public Intersect(BigDecimal x, BigDecimal fx) {
        this.x = processCoordinate(x);
        this.fx = processCoordinate(fx);
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getFx() {
        return fx;
    }

    public Double getDoubleX() {
        return x.doubleValue();
    }

    public Double getDoubleFx() {
        return fx.doubleValue();
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, fx);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Intersect)) return false;
        Intersect comp = (Intersect) obj;
        return x.equals(comp.getX()) && fx.equals(comp.getFx());
    }

    public static Intersect getIntersectResult(BigDecimal x, BigDecimal fx, MathContext mathContext) {
        return new Intersect(x.round(mathContext), fx.round(mathContext));
    }

    private BigDecimal processCoordinate(BigDecimal coord) {
        return coord.stripTrailingZeros();
    }
}

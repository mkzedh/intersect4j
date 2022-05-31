package org.mkzh.intersect4j.util;

import java.math.BigDecimal;

public class Intersect {
    private BigDecimal x;
    private BigDecimal fx;

    public Intersect(BigDecimal x, BigDecimal fx) {
        this.x = x;
        this.fx = fx;
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
}

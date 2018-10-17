package xxx;

import java.math.BigDecimal;

public class SimpleUnit extends Unit {
    private BigDecimal coeff;

    /**
     * Create a new type of the unit where:
     * @param name      the full name of the unit (like "foot")
     * @param shortName short symbol (like "ft")
     * @param coeff     coefficient for convertation to the base unit (like 0.3048)
     */
    public SimpleUnit(String name, String shortName, BigDecimal coeff) {
        this.name = name;
        this.shortName = shortName;
        this.coeff = coeff;
    }

    @Override
    public Result fromBase(Result base) {
        return new Result(Math.multiply(base.amount, coeff), this);
    }

    @Override
    public Result toBase(Result value) {
        return new Result(Math.divide(value.amount, coeff), category.baseUnit);
    }
}

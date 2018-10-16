package xxx;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleUnit extends Unit {
    private Category category;
    private BigDecimal coeff;

    /**
     * Create a new type of the unit where:
     * @param name      the full name of the unit (like "foot")
     * @param shortName short symbol (like "ft")
     * @param coeff     coefficient for convertation to the base unit (like 0.3048)
     */
    public SimpleUnit(String name, String shortName, BigDecimal coeff, Category category) {
        this.name = name;
        this.shortName = shortName;
        this.coeff = coeff;
        this.category = category;
    }

    @Override
    public Result fromBase(Result base) {
        return new Result(base.amount.multiply(coeff), this);
    }

    @Override
    public Result toBase(Result value) {
        return new Result(value.amount.divide(coeff, RoundingMode.FLOOR), category.baseUnit);
    }
}

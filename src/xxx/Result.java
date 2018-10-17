package xxx;

import java.math.BigDecimal;
import java.util.Map;

public class Result {
    public BigDecimal amount;
    public Unit unit;
    public Map.Entry<String, BigDecimal> modifier = null;

    public Result() {
        this.amount = null;
        this.unit = null;
    }

    public Result(BigDecimal amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public Result(BigDecimal amount, Unit unit, Map.Entry<String, BigDecimal> modifier) {
        this(amount, unit);
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return amount + " " + (modifier == null ?
                unit.name :
                modifier.getKey() + (modifier.getKey().length() <= 2 ?
                        unit.shortName :
                        unit.name
                )
        ) + (amount.compareTo(BigDecimal.ONE) > 0 ? "s" : "");
    }
}

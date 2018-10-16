package xxx;

import java.math.BigDecimal;

public class Result {
    public BigDecimal amount;
    public Unit unit;

    public Result() {
        this.amount = null;
        this.unit = null;
    }

    public Result(BigDecimal amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }
}

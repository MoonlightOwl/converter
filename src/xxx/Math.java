package xxx;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Math {
    public static final int PRECISION = 10;

    public static BigDecimal truncate(BigDecimal x) {
        if (x.scale() > PRECISION)
            return x.setScale(PRECISION, RoundingMode.HALF_UP).stripTrailingZeros();
        else
            return x.stripTrailingZeros();
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        return truncate(a.divide(b, PRECISION, RoundingMode.HALF_UP));
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return truncate(a.multiply(b));
    }
}

package xxx;

import java.math.BigDecimal;

/**
 * This class contains an example of the Converter usage.
 */

public class Test {
    public static void main(String[] args) {
        Category LENGTH = new Category("length");
        Unit METER = new SimpleUnit("meter", "m", BigDecimal.ONE, LENGTH);
        Unit FOOT = new SimpleUnit("foot", "ft", new BigDecimal("0.3048"), LENGTH);

        Converter.registerUnit(METER);
        Converter.registerUnit(FOOT);

        LENGTH.baseUnit = METER;

        Result result = Converter.convert("10 kilometers", "foots");
        System.out.println(result.amount + " " + result.unit);
    }
}

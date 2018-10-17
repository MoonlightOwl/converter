package xxx;

import java.math.BigDecimal;

/**
 * This class contains an example of the Converter usage.
 */

public class Test {
    public static void main(String[] args) {
        Category length = Converter.registerCategory("length");
        length.registerBaseUnit(new SimpleUnit("meter", "m", BigDecimal.ONE));
        length.registerUnit(new SimpleUnit("foot", "ft", new BigDecimal("0.3048")));
        length.registerUnit(new SimpleUnit("inch", "in", new BigDecimal("0.0254")));

        Category data = Converter.registerCategory("data");
        data.registerBaseUnit(new SimpleUnit("bit", "bit", BigDecimal.ONE));
        data.registerUnit(new SimpleUnit("byte", "b", new BigDecimal(8)));

        System.out.println(Converter.convert("10 kilometers", "nft"));
        System.out.println(Converter.convert("1024 Mb", "Gb"));
        System.out.println(Converter.convert("8 bit", "meters"));
        System.out.println(Converter.convert("25.4 mm", "in"));
    }
}

package xxx;

import java.math.BigDecimal;
import java.util.HashMap;

public class Parser {
    private static HashMap<String, BigDecimal> modifiers = new HashMap<>();

    static {
        modifiers.put("yotta", new BigDecimal("1000000000000000000000000"));
        modifiers.put("Y",     new BigDecimal("1000000000000000000000000"));
        modifiers.put("zetta", new BigDecimal("1000000000000000000000"));
        modifiers.put("Z",     new BigDecimal("1000000000000000000000"));
        modifiers.put("exa",   new BigDecimal("1000000000000000000"));
        modifiers.put("E",     new BigDecimal("1000000000000000000"));
        modifiers.put("peta",  new BigDecimal("1000000000000000"));
        modifiers.put("P",     new BigDecimal("1000000000000000"));
        modifiers.put("tera",  new BigDecimal("1000000000000"));
        modifiers.put("T",     new BigDecimal("1000000000000"));
        modifiers.put("giga",  new BigDecimal("1000000000"));
        modifiers.put("G",     new BigDecimal("1000000000"));
        modifiers.put("mega",  new BigDecimal("1000000"));
        modifiers.put("M",     new BigDecimal("1000000"));
        modifiers.put("kilo",  new BigDecimal("1000"));
        modifiers.put("k",     new BigDecimal("1000"));
        modifiers.put("hecto", new BigDecimal("100"));
        modifiers.put("h",     new BigDecimal("100"));
        modifiers.put("deca",  new BigDecimal("10"));
        modifiers.put("da",    new BigDecimal("10"));
        modifiers.put("deci",  new BigDecimal("0.1"));
        modifiers.put("d",     new BigDecimal("0.1"));
        modifiers.put("centi", new BigDecimal("0.01"));
        modifiers.put("c",     new BigDecimal("0.01"));
        modifiers.put("milli", new BigDecimal("0.001"));
        modifiers.put("m",     new BigDecimal("0.001"));
        modifiers.put("micro", new BigDecimal("0.000001"));
        modifiers.put("µ",     new BigDecimal("0.000001"));
        modifiers.put("nano",  new BigDecimal("0.000000001"));
        modifiers.put("n",     new BigDecimal("0.000000001"));
        modifiers.put("pico",  new BigDecimal("0.000000000001"));
        modifiers.put("p",     new BigDecimal("0.000000000001"));
        modifiers.put("femto", new BigDecimal("0.000000000000001"));
        modifiers.put("f",     new BigDecimal("0.000000000000001"));
        modifiers.put("atto",  new BigDecimal("0.000000000000000001"));
        modifiers.put("a",     new BigDecimal("0.000000000000000001"));
        modifiers.put("zepto", new BigDecimal("0.000000000000000000001"));
        modifiers.put("z",     new BigDecimal("0.000000000000000000001"));
        modifiers.put("yocto", new BigDecimal("0.000000000000000000000001"));
        modifiers.put("y",     new BigDecimal("0.000000000000000000000001"));
    }

    public static Result detectModifier(String input) {
        Result result = new Result();
        modifiers.entrySet().stream()
            .filter(entry -> input.startsWith(entry.getKey()) && Converter.unitByName(input.substring(entry.getKey().length())) != null)
            .findFirst().ifPresent(entry -> {
            result.unit = Converter.unitByName(input.substring(entry.getKey().length()));
            result.amount = entry.getValue();
        });
        if (result.unit == null) {
            result.unit = Converter.unitByName(input);
            if (result.unit != null) result.amount = BigDecimal.ONE;
        }
        if (result.unit == null) return null;
        else return result;
    }

    public static Result fromString(String input) {
        String[] parts = input.split("\\s+");
        BigDecimal amount = new BigDecimal(parts[0]);
        Result result = detectModifier(parts[1]);
        if (result != null) result.amount = result.amount.multiply(amount);
        return result;
    }
}

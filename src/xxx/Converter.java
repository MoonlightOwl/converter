package xxx;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Converter {
    private static HashMap<String, Unit> units = new HashMap<>();

    public static void registerUnit(Unit unit) {
        units.put(unit.name, unit);
        units.put(unit.shortName, unit);
    }

    public static Unit unitByName(String input) {
        return units.entrySet().stream()
                .filter(entry -> input.startsWith(entry.getKey()))
                .findFirst()
                .map(Map.Entry::getValue).orElse(null);
    }

    /**
     * Takes a convertation request and returns corresponding Result.
     * Input examples: ("10 ft", "meters"), ("1 nm", "km")
     */
    public static Result convert(String input, String output) {
        Result source = Parser.fromString(input);
        Result destination = Parser.detectModifier(output);
        if (source != null && destination != null) {
            Result result = destination.unit.fromBase(source.unit.toBase(source));
            // do some additional calculation to respect the requested modifier
            if (source.modifier != null) result.amount = result.amount.multiply(source.modifier.getValue());
            if (destination.modifier != null) result.amount = result.amount.divide(destination.modifier.getValue(), RoundingMode.FLOOR);
            result.modifier = destination.modifier;
            return result;
        } else return null;
    }
}

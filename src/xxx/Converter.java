package xxx;

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

    public static Result convert(String input, String output) {
        Result source = Parser.fromString(input);
        Result destination = Parser.detectModifier(output);
        return destination.unit.fromBase(source.unit.toBase(source));
    }
}

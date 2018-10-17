package xxx;

import java.util.HashMap;

public class Converter {

    private static HashMap<String, Category> categories = new HashMap<>();

    public static Category registerCategory(String name) {
        Category category = new Category(name);
        categories.put(category.name, category);
        return category;
    }

    public static Category categoryByName(String name) {
        return categories.get(name);
    }

    public static Unit unitByName(String name) {
        for (Category category : categories.values()) {
            Unit unit = category.unitByName(name);
            if (unit != null) return unit;
        }
        return null;
    }

    /**
     * Takes a convertation request and returns corresponding Result.
     * Input examples: ("10 ft", "meters"), ("1 nm", "km")
     */
    public static Result convert(String input, String output) {
        Result source = Parser.fromString(input);
        Result destination = Parser.detectModifier(output);
        if (source != null && destination != null) {
            if (source.unit.category != destination.unit.category) {
                return null;
            }
            Result result = destination.unit.fromBase(source.unit.toBase(source));
            // do some additional calculation to respect the requested modifier
            if (source.modifier != null) result.amount = Math.multiply(result.amount, source.modifier.getValue());
            if (destination.modifier != null) result.amount = Math.divide(result.amount, destination.modifier.getValue());
            result.modifier = destination.modifier;
            return result;
        } else {
            return null;
        }
    }
}

package xxx;

import java.util.HashMap;
import java.util.Map;

public class Category {
    public String name;
    public Unit baseUnit;

    private HashMap<String, Unit> units = new HashMap<>();

    public void registerUnit(Unit unit) {
        units.put(unit.name, unit);
        units.put(unit.shortName, unit);
        unit.category = this;
    }

    public void registerBaseUnit(Unit unit) {
        registerUnit(unit);
        baseUnit = unit;
    }

    public Unit unitByName(String name) {
        return units.entrySet().stream()
                .filter(entry -> name.startsWith(entry.getKey()))
                .findFirst()
                .map(Map.Entry::getValue).orElse(null);
    }

    public Category(String name) {
        this.name = name;
    }
}

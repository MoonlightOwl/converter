package xxx;

public class Category {
    public String name;
    public Unit baseUnit;

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Unit baseUnit) {
        this.name = name;
        this.baseUnit = baseUnit;
    }
}

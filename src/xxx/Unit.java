package xxx;

abstract public class Unit {
    /**
     * The category this unit belongs to.
     * Only the units within the same category can be converted to each other.
     */
    public Category category;

    /**
     * Names of the unit, that will be used lated for parsing.
     * For example: "meter" / "m"
     */
    public String name, shortName;

    /**
     * Convert some amount of the base unit to the corresponding amount of this unit.
     */
    abstract public Result fromBase(Result base);

    /**
     * Convert some amount of this unit to the corresponding amount of the base unit.
     */
    abstract public Result toBase(Result value);

    @Override
    public String toString() {
        return "Unit(" + name + ", " + shortName + ")";
    }
}

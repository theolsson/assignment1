/*Developer note:
Order of these constants matters: Values must be listed in clockwise order from NORTH(0),
and each getCompasValue() must equal the constant's position in getCompassDirections()*/
public enum CompassDirection {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private final int value;

    CompassDirection(int value){
        this.value = value;
    }

    public int getCompassValue(){
        return value;
    }

    public static CompassDirection[] getCompassDirections(){
        return values();
    }

    public static CompassDirection getCompassValueByInt(int value){
        for (CompassDirection compassDirection : values()){
            if (compassDirection.getCompassValue() == value){
                return compassDirection;
            }
        }
        throw new IllegalArgumentException("No matching CompasDirection for value: " + value);
    }
}
import java.awt.Point;

enum Direction{
    UP(0, 1),
    RIGHT(1, 0),
    DOWN(0, -1),
    LEFT(-1, 0);

    private final Point vector;

    Direction(int x, int y) {
        vector = new Point(x, y);
    }

    public Point getVector() {
        return vector;
    }

    public Direction getLeftTurnDirection() {
        // ordinal() returns the position of the enum constant (UP = 0, RIGHT = 1, etc.)
        int indexNewDir = (ordinal() - 1) % 4;
        return values()[indexNewDir];
    }

    public Direction getRightTurnDirection() {
        // ordinal() returns the position of the enum constant (UP = 0, RIGHT = 1, etc.)
        int indexNewDir = (ordinal() + 1) % 4;
        return values()[indexNewDir];
    }
}
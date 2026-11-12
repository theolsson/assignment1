import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    private Point2D.Double currentPosition = new Point2D.Double(0,0);
    private Direction currentDirection = Direction.UP;

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
    }

    public void move() {
        Point dirVector = currentDirection.getVector();

        double dx = dirVector.x * currentSpeed;
        double dy = dirVector.y * currentSpeed;

        currentPosition.x += dx;
        currentPosition.y += dy;
    }

    public void turnLeft() {
        currentDirection = currentDirection.getLeftTurnDirection();
    }

    public void turnRight() {
        currentDirection = currentDirection.getRightTurnDirection();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();


}

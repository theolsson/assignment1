import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    
    protected Point2D.Double currentPosition = new Point2D.Double(0,0);
    protected Direction currentDirection = Direction.UP;
    
    public Car(){}

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

    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
        
    abstract public double speedFactor();
    
    // TODO fix this method according to assignment pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to assignment pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }
}

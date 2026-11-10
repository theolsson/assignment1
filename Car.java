import java.awt.*;
import java.awt.geom.Point2D;

abstract public class Car implements Movable{
    private final int nrDoors; // Number of doors on the car
    private final double enginePower;
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private final Point2D.Double currentCoordinate; // The cars coordinate (x, y) as doubles
    private CompassDirection currentDirection;

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentCoordinate = new Point2D.Double(0,0);
        this.currentDirection = CompassDirection.NORTH;
    }

    public Car(int nrDoors, double enginePower, Color color, String modelName, Point2D.Double currentCoordinate, CompassDirection currentDirection){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentCoordinate = new Point2D.Double(currentCoordinate.x, currentCoordinate.y);
        this.currentDirection = currentDirection;
    }

    public CompassDirection getCurrentDirection(){
        return currentDirection;
    }

    private void setCurrentDirection(CompassDirection direction){
        currentDirection = direction;
    }

    public Point2D.Double getCurrentCoordinate(){
        return new Point2D.Double(currentCoordinate.x, currentCoordinate.y);
    }

    public void setCurrentCoordinate(Point2D.Double point2D){
        currentCoordinate.setLocation(point2D.x, point2D.y);
    }

    public String getModelName(){
        return modelName;
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

    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method a
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void move(){
        /*Developer note:
        (x, y) two plane coordinate system */
        switch (currentDirection){
            case NORTH:
                currentCoordinate.y += currentSpeed;
                break;
            case EAST:
                currentCoordinate.x += currentSpeed;
                break;
            case SOUTH:
                currentCoordinate.y -= currentSpeed;
                break;
            case WEST:
                currentCoordinate.x -= currentSpeed;
                break;
        }
    }

    public void turnLeft(int steps){
        setCurrentDirection(turn(-steps));
    }

    public void turnRight(int steps){
        setCurrentDirection(turn(steps));
    }

    private CompassDirection turn(int steps){
        /*Developer note:
        Early exit on 0 steps for readability, removing this if produces the same results*/
        if (steps == 0){
            return currentDirection;
        }

        int directionLength = CompassDirection.getCompassDirections().length;
        /*Developer note:
        Adds steps to the current compass value and wraps the result into the range 0 to directionLength - 1.
        Math.floorMod is used instead of % so negative steps (counter-clockwise) never produce a negative index.*/
        int newDirectionValue = Math.floorMod(currentDirection.getCompassValue() + steps, directionLength);

        return CompassDirection.getCompassDirections()[newDirectionValue];
    }
}
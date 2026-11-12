import java.awt.*;

abstract public class Car {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower;
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
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
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        newSpeed = clamp(newSpeed, 0, enginePower);

        this.currentSpeed = newSpeed;
    }

    private void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        newSpeed = clamp(newSpeed, 0, enginePower);

        this.currentSpeed = newSpeed;
    }

    public void gas(double amount){
        if ((amount >= 0) && (amount<=1))
            incrementSpeed(amount);
    }

    public void brake(double amount){
        if ((amount >= 0) && (amount<=1))
            decrementSpeed(amount);
    }

    // Helper function
    private double clamp(double inputValue, double min, double max){
        inputValue = Math.min(inputValue, max);
        inputValue = Math.max(inputValue, min);
        return inputValue;
    }
}

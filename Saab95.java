import java.awt.*;
import java.awt.geom.Point2D;

public class Saab95 extends Car {

    private boolean turboOn;
    
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        this.turboOn = false;
        stopEngine();
    }

    public Saab95(Point2D.Double currentCoordinate, CompassDirection currentDirection){
        super(2, 125, Color.red, "Saab95", currentCoordinate, currentDirection);
        this.turboOn = false;
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}

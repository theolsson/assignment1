import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;
    
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
        stopEngine();
    }

    public Volvo240(Point2D.Double currentCoordinate, CompassDirection currentDirection){
        super(4, 100, Color.black, "Volvo240", currentCoordinate, currentDirection);
        stopEngine();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}

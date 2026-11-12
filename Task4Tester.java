public class Task4Tester {
    void main(){
        Saab95 myCar = new Saab95();
        IO.println("Car Speed: " + myCar.getCurrentSpeed());
        IO.println("Pressing gas...");
        myCar.gas(1);
        IO.println("Car Speed: " + myCar.getCurrentSpeed());
        IO.println("Pressing gas with (-1)...");
        myCar.gas(-1);
        IO.println("Car Speed: " + myCar.getCurrentSpeed());
        IO.println("Braking with (-1)...");
        myCar.brake(-1);
        IO.println("Car Speed: " + myCar.getCurrentSpeed());
        IO.println("Braking with 1...");
        myCar.brake(1);
        IO.println("Car Speed: " + myCar.getCurrentSpeed());
        IO.println("Braking with 1 twice...");
        myCar.brake(1);
        myCar.brake(1);
        IO.println("Car Speed: " + myCar.getCurrentSpeed());
        IO.println(String.format("Engine Power is: %f", myCar.getEnginePower()));
        IO.println("Gassing Engine Power number + 1");
        for (int i = 0; i <= myCar.getEnginePower(); i++)
            myCar.gas(1);
        IO.println("Car Speed: " + myCar.getCurrentSpeed());
    }
}

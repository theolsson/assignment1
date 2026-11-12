import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    interface Check {
        String getName();
        boolean run();
    }

    static class ColorCheck implements Check {
        private final Car car;
        private final Color expected;
        private final String label;

        ColorCheck(String label, Car car, Color expected) {
            this.label = label;
            this.car = car;
            this.expected = expected;
        }

        public String getName() { return label + " color"; }
        public boolean run() { return car.getColor().equals(expected); }
    }
    
    static class DoorsCheck implements Check {
    private final Car car;
    private final int expected;
    private final String label;

    public DoorsCheck(String label, Car car, int expected) {
        this.label = label;
        this.car = car;
        this.expected = expected;
    }

    @Override
    public String getName() {
        return label + " number of doors";
    }
    @Override
    public boolean run() {
        return car.getNrDoors() == expected;
    }
    }

    static class EnginePowerCheck implements Check {
    private static final double TOLERANCE = 0.0001;
    private final Car car;
    private final double expected;
    private final String label;
    public EnginePowerCheck(String label, Car car, double expected) {
        this.label = label;
        this.car = car;
        this.expected = expected;
    }

    @Override
    public String getName() {
        return label + " engine power";
    }
    @Override
    public boolean run() {
        return Math.abs(car.getEnginePower() - expected) < TOLERANCE;
    }
    }
    
    public static class Reporter {
    public void report(String name, boolean passed) {
        System.out.println((passed ? "PASS: " : "FAIL: ") + name);
    }
    }
    public static class TestRunner {
    private final Reporter reporter;

    public TestRunner(Reporter reporter) {
        this.reporter = reporter;
    }

    public void runAll(List<Check> checks) {
        int failed = 0;
        for (Check check : checks) {
            boolean passed = check.run();
            reporter.report(check.getName(), passed);
            if (!passed) {
                failed++;
            }
        }
        System.out.println(checks.size() - failed + "/" + checks.size() + " passed");
    }
}

    public static void main(String[] args) {
        Car volvo = new Volvo240();
        Car saab = new Saab95();

        List<Check> checks = new ArrayList<>();

        checks.add(new ColorCheck("Volvo240", volvo, Color.BLACK));
        checks.add(new DoorsCheck("Saab95", saab,2));
        checks.add(new EnginePowerCheck("Volvo240", volvo, 100));
        new TestRunner(new Reporter()).runAll(checks);
        //checks.add(new StartSpeedCheck("Volvo240", volvo, 0));
        //checks.add(new StartSpeedCheck("Saab95", saab, 0));
   
    
        }
    }


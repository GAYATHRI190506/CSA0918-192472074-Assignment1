package TASK12;
import java.time.LocalTime;

public class Car extends Vehicle {
    protected static final double RATE_PER_HOUR = 30.0;

    public Car(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateFee(int minutes, LocalTime entryTime) {
        return startedHours(minutes) * RATE_PER_HOUR;
    }
}

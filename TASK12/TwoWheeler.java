package TASK12;
import java.time.LocalTime;

public class TwoWheeler extends Vehicle {
    private static final double RATE_PER_HOUR = 10.0;

    public TwoWheeler(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateFee(int minutes, LocalTime entryTime) {
        return startedHours(minutes) * RATE_PER_HOUR;
    }
}

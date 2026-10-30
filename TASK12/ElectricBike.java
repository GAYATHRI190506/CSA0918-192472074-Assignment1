package TASK12;
import java.time.LocalTime;

public class ElectricBike extends Vehicle {
    private static final double FLAT_FEE = 25.0;

    public ElectricBike(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateFee(int minutes, LocalTime entryTime) {
        if (minutes < 0) {
            throw new IllegalArgumentException(
                "Parking duration cannot be negative"
            );
        }

        return FLAT_FEE;
    }
}

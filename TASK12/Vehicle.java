package TASK12;
import java.time.LocalTime;

public abstract class Vehicle {
    private final String registrationNumber;

    public Vehicle(String registrationNumber) {
        if (registrationNumber == null ||
            registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Registration number cannot be empty"
            );
        }
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public abstract double calculateFee(
        int minutes, LocalTime entryTime
    );

    protected long startedHours(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException(
                "Parking duration cannot be negative"
            );
        }
        return (minutes + 59L) / 60;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " [" + registrationNumber + "]";
    }
}

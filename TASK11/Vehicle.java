package TASK11;
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

    protected abstract double ratePerHour();

    public double calculateFee(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException(
                "Parking duration cannot be negative"
            );
        }

        long hours = (minutes + 59L) / 60;
        return hours * ratePerHour();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " [" + registrationNumber + "]";
    }
}

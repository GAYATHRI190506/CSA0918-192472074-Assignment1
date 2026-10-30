package TASK12;
import java.time.LocalTime;

public class DeliveryVan extends Car {

    public DeliveryVan(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateFee(int minutes, LocalTime entryTime) {
        long hours = startedHours(minutes);

        if (entryTime == null) {
            throw new IllegalArgumentException(
                "Entry time cannot be null"
            );
        }

        boolean daytime =
            !entryTime.isBefore(LocalTime.of(9, 0)) &&
             entryTime.isBefore(LocalTime.of(17, 0));

        double rate = daytime
                ? RATE_PER_HOUR * 2
                : RATE_PER_HOUR;

        return hours * rate;
    }
}

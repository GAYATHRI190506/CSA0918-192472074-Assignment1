package TASK11;
public class ParkingTicket {
    private static int nextTicketNumber = 1001;

    private final int ticketNumber;
    private final Vehicle vehicle;
    private final int parkingMinutes;
    private final double fee;

    public ParkingTicket(Vehicle vehicle, int parkingMinutes) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        if (parkingMinutes < 0) {
            throw new IllegalArgumentException(
                "Parking minutes cannot be negative"
            );
        }

        this.ticketNumber = nextTicketNumber++;
        this.vehicle = vehicle;
        this.parkingMinutes = parkingMinutes;
        this.fee = vehicle.calculateFee(parkingMinutes);
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getParkingMinutes() {
        return parkingMinutes;
    }

    public double getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketNumber
                + " | " + vehicle
                + " | Minutes: " + parkingMinutes
                + " | Fee: Rs " + fee;
    }
}

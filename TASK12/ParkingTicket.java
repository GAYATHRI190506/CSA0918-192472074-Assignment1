
package TASK12;

public class ParkingTicket {
    private static int nextTicketNumber = 1001;

    private final int ticketNumber;
    private final Vehicle vehicle;
    private final int parkingMinutes;
    private final double fee;
    private final int floorNumber;
    private final int slotNumber;

    public ParkingTicket(Vehicle vehicle, int parkingMinutes,
                         double fee, int floorIndex, int slotIndex) {

        if (vehicle == null || parkingMinutes < 0) {
            throw new IllegalArgumentException("Invalid ticket details");
        }

        this.ticketNumber = nextTicketNumber++;
        this.vehicle = vehicle;
        this.parkingMinutes = parkingMinutes;
        this.fee = fee;
        this.floorNumber = floorIndex + 1;
        this.slotNumber = slotIndex + 1;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public double getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketNumber
                + " | " + vehicle
                + " | Minutes: " + parkingMinutes
                + " | Floor: " + floorNumber
                + " | Slot: " + slotNumber
                + " | Fee: Rs " + fee;
    }
}

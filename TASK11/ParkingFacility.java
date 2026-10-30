package TASK11;
import java.util.ArrayList;
import java.util.List;

public class ParkingFacility {
    private final Vehicle[] slots;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingFacility(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "Capacity must be positive"
            );
        }

        slots = new Vehicle[capacity];
    }

    public ParkingTicket parkVehicle(Vehicle vehicle, int minutes) {
        if (vehicle == null) {
            throw new IllegalArgumentException(
                "Vehicle cannot be null"
            );
        }

        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                ParkingTicket ticket =
                    new ParkingTicket(vehicle, minutes);

                slots[i] = vehicle;
                tickets.add(ticket);

                System.out.println(
                    "Vehicle parked in slot " + (i + 1)
                );

                return ticket;
            }
        }

        System.out.println("Parking is full.");
        return null;
    }

    public boolean removeVehicle(String registrationNumber) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null &&
                slots[i].getRegistrationNumber()
                    .equals(registrationNumber)) {

                slots[i] = null;

                System.out.println(
                    "Vehicle removed from slot " + (i + 1)
                );

                return true;
            }
        }

        System.out.println("Vehicle not found.");
        return false;
    }

    public void displayParkedVehicles() {
        System.out.println("\n--- Parked Vehicles ---");

        boolean found = false;

        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null) {
                System.out.println(
                    "Slot " + (i + 1) + ": " + slots[i]
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles parked.");
        }
    }

    public void displayTickets() {
        System.out.println("\n--- Parking Tickets ---");

        if (tickets.isEmpty()) {
            System.out.println("No tickets generated.");
            return;
        }

        for (ParkingTicket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}

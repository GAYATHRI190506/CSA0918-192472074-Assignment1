package TASK12;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingFacility {
    private final Vehicle[][] floors;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingFacility(int[] floorCapacities) {
        if (floorCapacities == null || floorCapacities.length != 5) {
            throw new IllegalArgumentException(
                "Exactly five floor capacities are required"
            );
        }

        floors = new Vehicle[5][];

        for (int i = 0; i < 5; i++) {
            if (floorCapacities[i] <= 0) {
                throw new IllegalArgumentException(
                    "Each floor must have positive capacity"
                );
            }

            floors[i] = new Vehicle[floorCapacities[i]];
        }
    }

    public ParkingTicket parkVehicle(
            Vehicle vehicle, int minutes, LocalTime entryTime) {
        if (vehicle == null) {
            throw new IllegalArgumentException(
                "Vehicle cannot be null"
            );
        }

        for (int f = 0; f < floors.length; f++) {
            for (int s = 0; s < floors[f].length; s++) {
                if (floors[f][s] == null) {
                    ParkingTicket ticket = new ParkingTicket(
                        vehicle,
                        minutes,
                        vehicle.calculateFee(minutes, entryTime),
                        f,
                        s
                    );

                    floors[f][s] = vehicle;
                    tickets.add(ticket);

                    System.out.println(
                        "Parked on floor " + (f + 1)
                        + ", slot " + (s + 1)
                    );

                    return ticket;
                }
            }
        }

        System.out.println("Parking is full.");
        return null;
    }

    public boolean removeVehicle(String registrationNumber) {
        for (int f = 0; f < floors.length; f++) {
            for (int s = 0; s < floors[f].length; s++) {
                Vehicle vehicle = floors[f][s];

                if (vehicle != null &&
                    vehicle.getRegistrationNumber()
                        .equals(registrationNumber)) {
                    floors[f][s] = null;

                    System.out.println(
                        "Removed from floor " + (f + 1)
                        + ", slot " + (s + 1)
                    );

                    return true;
                }
            }
        }

        System.out.println("Vehicle not found.");
        return false;
    }

    public void displayParkedVehicles() {
        System.out.println("\n--- Parked Vehicles ---");

        for (int f = 0; f < floors.length; f++) {
            System.out.println("Floor " + (f + 1) + ":");

            boolean found = false;

            for (int s = 0; s < floors[f].length; s++) {
                if (floors[f][s] != null) {
                    System.out.println(
                        "  Slot " + (s + 1) + ": " + floors[f][s]
                    );
                    found = true;
                }
            }

            if (!found) {
                System.out.println("  No vehicles parked.");
            }
        }
    }

    public void displayTickets() {
        System.out.println("\n--- Parking Tickets ---");

        for (ParkingTicket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}

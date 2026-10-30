
package TASK12;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        int[] capacities = {2, 3, 4, 2, 5};

        ParkingFacility parking =
                new ParkingFacility(capacities);

        Vehicle car = new Car("TN01A1234");
        Vehicle bike = new TwoWheeler("TN02B5678");
        Vehicle eBike = new ElectricBike("TN03C9012");
        Vehicle van = new DeliveryVan("TN04D3456");

        System.out.println("===== CAMPUS SMART PARKING =====");

        parking.parkVehicle(car, 120, LocalTime.of(10, 0));
        parking.parkVehicle(bike, 60, LocalTime.of(8, 0));
        parking.parkVehicle(eBike, 180, LocalTime.of(11, 0));
        parking.parkVehicle(van, 120, LocalTime.of(10, 0));

        parking.displayParkedVehicles();

        parking.displayTickets();

        VisitorPass pass = new VisitorPass(
                "Campus Visitor", LocalDate.now());

        System.out.println("\n===== VISITOR PASS =====");
        System.out.println(pass);

        System.out.println(
                "Valid today: " + pass.isValidOn(LocalDate.now()));

        System.out.println("\n===== PARKING SYSTEM COMPLETED =====");
    }
}

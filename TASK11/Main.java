package TASK11;
public class Main {
    public static void main(String[] args) {
        ParkingFacility parking = new ParkingFacility(3);

        Vehicle bike = new TwoWheeler("TN01A1234");
        Vehicle car = new Car("TN02B5678");

        ParkingTicket ticket1 = parking.parkVehicle(bike, 60);
        ParkingTicket ticket2 = parking.parkVehicle(car, 130);

        parking.displayParkedVehicles();
        parking.displayTickets();

        System.out.println("\n--- Fee Summary ---");
        if (ticket1 != null) {
            System.out.println("Bike fee: Rs " + ticket1.getFee());
        }
        if (ticket2 != null) {
            System.out.println("Car fee: Rs " + ticket2.getFee());
        }

        parking.removeVehicle("TN01A1234");
        parking.displayParkedVehicles();
    }
}

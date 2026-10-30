package TASK11;
public class TwoWheeler extends Vehicle {

    public TwoWheeler(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    protected double ratePerHour() {
        return 10.0;
    }
}

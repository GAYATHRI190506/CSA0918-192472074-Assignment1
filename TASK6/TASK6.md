# TASK 6 – Design the Inheritance Hierarchy

## 1. Aim

To design an inheritance hierarchy for parking-system vehicles, understand inherited and specialised behaviour, and demonstrate the use of the `super` keyword.

## 2. Inheritance Hierarchy

Inheritance allows a subclass to reuse and specialise the fields and methods of a superclass.

The proposed hierarchy is:

- Vehicle: Abstract superclass representing common vehicle properties and behaviour.
- TwoWheeler: Represents a two-wheeler and defines its parking rate.
- Car: Represents a car and defines its parking rate.
- ElectricCar: Extends Car and implements the Chargeable interface for charging behaviour.

The relationships are:

- TwoWheeler extends Vehicle.
- Car extends Vehicle.
- ElectricCar extends Car.
- ElectricCar implements Chargeable.

## 3. UML Class Diagram

```text
                 <<abstract>>
                   Vehicle
          -------------------------
          - regNo: String
          -------------------------
          + getRegNo(): String
          + calculateFee(minutes): double
          # ratePerHour(): double
                    ^
                    |
          +---------+---------+
          |                   |
     TwoWheeler              Car
     ------------        ------------
     + ratePerHour()     + ratePerHour()
                              ^
                              |
                         ElectricCar
                         ------------
                         + chargingFee(kWh): double
                              |
                         <<implements>>
                          Chargeable
```

The arrows represent inheritance. ElectricCar inherits the car's parking-rate behaviour and provides the charging capability through the Chargeable interface.

## 4. Inherited and Specialised Members

### Vehicle
Stores the common registration number and defines the general parking-fee calculation method.

### TwoWheeler
Inherits the common vehicle behaviour and provides a two-wheeler hourly rate.

### Car
Inherits the common vehicle behaviour and provides a car hourly rate.

### ElectricCar
Inherits from Car and implements charging behaviour. This allows parking fees and charging fees to be handled separately.

## 5. Use of super

The `super` keyword refers to the immediate superclass.

It can be used to:
- Invoke a superclass constructor.
- Call an overridden superclass method.
- Access an accessible superclass member.

Example:

```java
class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }
}
```

The `super(regNo)` statement invokes the Vehicle constructor to initialise the registration number.

## 6. Constructor Execution Trace

When an ElectricCar object is created:

```java
ElectricCar ev = new ElectricCar("TN03C3");
```

The constructor execution order is:

1. ElectricCar constructor begins.
2. Its `super(regNo)` call invokes the Car constructor.
3. The Car constructor invokes the Vehicle constructor.
4. The Vehicle constructor initialises the registration number.
5. Control returns to the Car constructor.
6. Control returns to the ElectricCar constructor.
7. The ElectricCar object is ready to use.

The superclass constructor executes before the subclass constructor body.

## 7. Alternative Concept: Composition

Instead of creating separate subclasses, a single Vehicle class could contain a VehicleType object that defines the vehicle category and rate.

For example, a Vehicle object could have a field called `vehicleType`, whose object provides the applicable hourly rate.

### Comparison

| Feature | Inheritance | Composition |
|---|---|---|
| Relationship | Car is a Vehicle | Vehicle has a VehicleType |
| Adding a vehicle type | Often requires a new subclass | Often requires a new type or strategy object |
| Fee calculation | Uses overridden methods | Delegates to the contained type or strategy |
| Time per fee calculation | O(1) for a fixed calculation | O(1) for a fixed strategy calculation |
| Space per vehicle | Object and reference overhead | Vehicle plus a type reference; type objects may be shared |

Both approaches can calculate a fee in constant time when the selected rate is available directly. Composition can be more flexible when behaviour changes independently of the vehicle itself.

## 8. Conclusion

Inheritance provides a clear hierarchy for common vehicle properties and specialised parking behaviour. The `super` keyword supports correct constructor chaining. Composition is an alternative when vehicle behaviour must be changed or combined more flexibly.


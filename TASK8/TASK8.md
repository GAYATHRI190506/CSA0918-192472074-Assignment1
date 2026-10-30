# TASK 8 – Apply Polymorphism

## 1. Aim

To demonstrate compile-time polymorphism through method overloading and runtime polymorphism through method overriding and dynamic method dispatch.

## 2. Compile-Time Polymorphism

Method overloading occurs when a class contains multiple methods with the same name but different parameter lists.

For example, a fee calculator could provide:

- `calculateFee(int minutes)`
- `calculateFee(LocalDateTime entry, LocalDateTime exit)`

The compiler selects the appropriate method based on the arguments supplied.

## 3. Runtime Polymorphism

A superclass reference can refer to an object of a subclass. This is called upcasting.

Example:

```java
Vehicle v = new Car("TN02B2");
```

Although the reference type is Vehicle, the actual object is Car. When `calculateFee()` calls `ratePerHour()`, Java selects the Car implementation at runtime.

## 4. Dynamic Method Dispatch Trace

- Declared reference type: Vehicle
- Actual object type: Car
- Method called: `calculateFee(130)`
- Overridden method executed: `Car.ratePerHour()`
- Billable duration: 3 hours
- Calculated fee: 3 × ₹30 = ₹90

This allows the program to calculate fees without a long if-else chain checking every vehicle category.

## 5. Interface and Equality

The Chargeable interface defines the charging capability. ElectricCar implements it and charges ₹12 per kWh.

The supplied equals() method compares registration numbers. Consequently, a Car and an ElectricCar with the same registration number compare as equal. This may be suitable if registration number defines vehicle identity, but duplicate active registrations must still be rejected by the parking facility.

## 6. Alternative Concept: instanceof Checks

An alternative implementation could use instanceof checks and casts to select the appropriate fee logic for each vehicle type.

Method overriding is more extensible because each subclass supplies its own behaviour. Adding a new subclass generally avoids modifying existing fee-selection code. With explicit type checks, the central selection logic often needs to be modified.

For a fixed set of vehicle types, both approaches can have constant-time fee selection. A sequence of k explicit type checks can take O(k) time in the worst case.

## 7. Conclusion

Method overloading provides compile-time polymorphism, while method overriding enables runtime polymorphism. The Chargeable interface separates charging capability from ordinary parking fees and allows the design to support additional capabilities.


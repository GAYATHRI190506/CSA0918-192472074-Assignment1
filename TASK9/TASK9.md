# TASK 9 – Introduce Abstraction

## 1. Aim

To use abstract classes and interfaces to separate common vehicle behaviour from specialised implementation in the Campus Smart-Parking System.

## 2. Abstract Class

An abstract class cannot be instantiated directly. It can contain fields, constructors, concrete methods and abstract methods.

In the parking system, Vehicle is an appropriate abstract class because every vehicle has common information, such as its registration number, and common behaviour, such as calculating a parking fee.

The `ratePerHour()` method can be abstract because different vehicle categories have different parking rates.

Example:

```java
abstract class Vehicle {
    private final String regNo;

    protected Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    protected abstract double ratePerHour();
}
```

## 3. Interface

An interface defines a capability that a class can implement.

The Chargeable interface represents the ability to calculate an electric-vehicle charging fee.

Example:

```java
interface Chargeable {
    double chargingFee(int kWh);
}
```

ElectricCar implements this interface and provides the charging-fee calculation.

## 4. Why Use Both?

An abstract class is appropriate for Vehicle because vehicle objects share state and constructor initialization. It can store common fields and implement shared methods.

An interface is appropriate for Chargeable because charging is a capability that can be implemented by different classes without requiring them to share the same superclass.

A class can implement multiple interfaces, allowing it to support several capabilities.

## 5. Default and Static Interface Methods

A default interface method provides a common implementation that implementing classes can inherit or override.

A static interface method belongs to the interface and can be called using the interface name.

These methods are useful for shared capability-related behaviour or utility operations that do not require object-specific state.

## 6. Alternative Concept: Interface and Abstract Class Reversed

If Vehicle were an interface, it could define common method contracts and provide default methods. However, an interface cannot have ordinary per-object instance fields or constructors.

Each implementing class would need to store its own registration number, or delegate that state to another class.

If Chargeable were an abstract class, a class could extend it, but Java does not allow a class to extend both Vehicle and another class. This could restrict the design when a vehicle needs to inherit from a different class.

Both interfaces and abstract classes support polymorphic method calls. The time to invoke a simple method is generally treated as O(1) for complexity analysis. Their main differences concern state, constructors, multiple inheritance of types and design flexibility, rather than a meaningful asymptotic space difference per vehicle.

## 7. Conclusion

The abstract Vehicle class represents common state and behaviour, while the Chargeable interface represents a specialised capability. This separation supports extensibility and reduces unnecessary dependencies between vehicle categories and charging behaviour.


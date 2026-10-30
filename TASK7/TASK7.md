# TASK 7 – Override and Specialise Behaviour

## 1. Aim

To demonstrate method overriding, use the `@Override` annotation, apply the `final` keyword appropriately, and override methods inherited from the Object class.

## 2. Method Overriding

Method overriding occurs when a subclass provides its own implementation of an inherited instance method with a compatible method signature.

In the parking system, different vehicle types can provide different hourly rates by overriding `ratePerHour()`.

Example:

```java
abstract class Vehicle {
    protected abstract double ratePerHour();

    public double calculateFee(int minutes) {
        long hours = (minutes + 59L) / 60;
        return hours * ratePerHour();
    }
}

class TwoWheeler extends Vehicle {
    @Override
    protected double ratePerHour() {
        return 10;
    }
}

class Car extends Vehicle {
    @Override
    protected double ratePerHour() {
        return 30;
    }
}
```

For a parking duration of 130 minutes:
- TwoWheeler: 3 × ₹10 = ₹30
- Car: 3 × ₹30 = ₹90

## 3. Rules of Method Overriding

1. The subclass method must have a compatible signature with the inherited method.
2. The return type must be the same or a permitted covariant return type.
3. The overriding method cannot reduce the visibility of the inherited method.
4. Private methods are not overridden because they are not inherited as accessible methods.
5. Static methods are hidden rather than overridden.
6. The `@Override` annotation helps the compiler detect mistakes in the intended override.

## 4. Use of final

The `final` keyword prevents certain changes.

- A final variable can be assigned only once.
- A final method cannot be overridden.
- A final class cannot be extended.

In the parking system, the vehicle registration number can be a final field after initialization. A method should be made final only if subclasses must not change its behaviour.

## 5. Overriding Object Class Methods

### toString()

The `toString()` method can return a readable representation of a vehicle, including its registration number and category.

### equals()

The `equals()` method defines when two objects should be considered logically equal.

For the parking system, two vehicle objects can be considered equal if they have the same normalized registration number. Normalization should be consistent, for example by trimming surrounding spaces and converting letters to uppercase.

However, two different vehicles must not be allowed to occupy the same active registration record at the same time.

### hashCode()

If two objects are equal according to `equals()`, they must return the same hash code. This is necessary for correct use in collections such as HashSet and HashMap.

Example:

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Vehicle)) return false;

    Vehicle other = (Vehicle) o;
    return regNo.equals(other.regNo);
}

@Override
public int hashCode() {
    return regNo.hashCode();
}
```

The example assumes `regNo` is a non-null field initialized by the Vehicle constructor.

## 6. Alternative Concept: switch Instead of Overriding

Instead of overriding a method for each vehicle type, one class could use a switch statement on a vehicle-type field.

For example, a fee calculator could select ₹10 for a two-wheeler and ₹30 for a car.

### Comparison

| Feature | Method overriding | switch statement |
|---|---|---|
| Fee selection | Dynamic method dispatch | Explicit type selection |
| Adding a new type | Add a suitable subclass | Usually modify the switch |
| Maintenance | Keeps type-specific behaviour in each class | Can centralize logic but may grow large |
| Time per calculation | O(1) for a fixed calculation | O(1) for a fixed number of cases |

For k vehicle types, a switch with a fixed number of cases is often described as O(1) relative to the number of parked vehicles. If implemented as a sequence of up to k explicit checks, selection can take O(k) time. The main difference is maintainability and extensibility rather than necessarily faster execution.

## 7. Conclusion

Method overriding allows each vehicle subclass to provide its own behaviour while using a common interface. The `@Override` annotation improves correctness, `final` protects selected members from modification, and consistent implementations of `equals()` and `hashCode()` support reliable object comparison.


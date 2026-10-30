# Task 10: Packages, Access Modifiers and Encapsulation

## 1. Objective

To organize the Campus Smart-Parking System using Java packages, apply access modifiers, protect data using encapsulation, and use wrapper classes with autoboxing and unboxing.

## 2. Package Structure

The application can be divided into three packages:

```text
src/
└── parking/
    ├── model/
    │   ├── Vehicle.java
    │   ├── Car.java
    │   └── ParkingTicket.java
    ├── service/
    │   ├── ParkingFacility.java
    │   └── FeeCalculator.java
    └── app/
        └── Main.java
```

- **parking.model:** Contains vehicle and ticket classes.
- **parking.service:** Contains parking allocation and fee-calculation logic.
- **parking.app:** Contains the main program used to run the application.

Each Java source file should begin with its corresponding package declaration. For example, `Vehicle.java` in the model package begins with `package parking.model;`.

## 3. Access Modifiers

| Modifier | Accessibility | Application |
|---|---|---|
| `private` | Within the same class only | Vehicle registration number |
| Default | Within the same package | Package-specific helper methods |
| `protected` | Same package and subclasses, including subclasses in other packages under Java's protected-access rules | Overridable vehicle methods |
| `public` | Accessible wherever the class and its members are accessible | Public methods such as `calculateFee()` |

## 4. Encapsulation and Validation

Encapsulation keeps data private and provides controlled access through methods.

Example:

```java
public class Vehicle {
    private String registrationNumber;

    public Vehicle(String registrationNumber) {
        setRegistrationNumber(registrationNumber);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null ||
            registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Registration number cannot be empty"
            );
        }
        this.registrationNumber = registrationNumber;
    }
}
```

The private field cannot be accessed directly from outside the class. The setter validates the registration number before storing it.

## 5. Wrapper Classes, Autoboxing and Unboxing

Java wrapper classes represent primitive values as objects. Examples include `Integer` for `int` and `Double` for `double`.

```java
Integer slotNumber = 5;       // Autoboxing
int slot = slotNumber;        // Unboxing

Integer a = 1000;
Integer b = 1000;

System.out.println(a.equals(b)); // true
System.out.println(a == b);     // Usually false
```

Autoboxing converts a primitive into its wrapper object, while unboxing converts a wrapper object into its primitive value. The `==` operator compares object references in this example, whereas `equals()` compares the integer values. Therefore, use `equals()` when comparing wrapper objects by value.

Unboxing a `null` wrapper object can cause a `NullPointerException`.

## 6. Alternative Design

An alternative is to make fields public and validate values wherever they are assigned. However, this duplicates validation logic and allows invalid data to enter the system. Private fields with validated setters provide better data protection and maintainability.

## 7. Complexity Analysis

- Reading a field through a getter: **O(1)**.
- Updating a field with a constant-time validation check: **O(1)**.
- Package organization does not change the time complexity of parking allocation or fee calculation.

## 8. Conclusion

Java packages organize the parking application into manageable modules. Access modifiers control visibility, encapsulation protects data, and wrapper classes support object-based operations. Validation helps maintain consistent and reliable parking records.
# TASK 4 – Design Classes, Objects and Constructors

## 1. Aim

To design Java classes and objects, understand constructors, use the `this` keyword and constructor chaining, and explain object creation and memory allocation.

## 2. Classes and Their Responsibilities

| Class | Fields | Methods |
|---|---|---|
| Vehicle | Registration number | getRegNo(), calculateFee() |
| ParkingTicket | Ticket number, vehicle, entry time, floor, slot | getTicketNumber(), calculateDuration() |
| ParkingFacility | Parking slots, ticket counter | allocate(), release() |
| ParkingFeeCalculator | Applicable rates | calculateFee() |

Each class represents a separate responsibility in the parking system.

## 3. Constructors

A constructor initializes an object when it is created.

### Default or no-argument constructor

A no-argument constructor initializes an object without requiring arguments.

### Parameterized constructor

A parameterized constructor accepts values to initialize an object.

### Constructor overloading

A class can contain multiple constructors with different parameter lists.

Example:

```java
class ParkingTicket {
    private final long ticketNumber;
    private final String regNo;

    ParkingTicket() {
        this(1, "UNKNOWN");
    }

    ParkingTicket(long ticketNumber) {
        this(ticketNumber, "UNKNOWN");
    }

    ParkingTicket(long ticketNumber, String regNo) {
        this.ticketNumber = ticketNumber;
        this.regNo = regNo;
    }
}
```

## 4. Use of this and Constructor Chaining

The `this` keyword refers to the current object. It distinguishes instance fields from constructor parameters.

For example, `this.regNo = regNo` assigns the parameter value to the object's field.

The statement `this(ticketNumber, "UNKNOWN")` invokes another constructor in the same class. This is called constructor chaining and reduces repeated initialization code.

A call to `this()` must be the first statement in a constructor.

## 5. Copy Constructor

A copy constructor creates a new object using the data of an existing object.

A copy constructor is not essential for every parking ticket. Tickets should have unique ticket numbers, so copying a ticket must not accidentally create a second active ticket with the same identity.

If copying is required, the design should clearly decide whether the new object represents a new ticket or merely a snapshot of an existing ticket.

## 6. Object Creation and Memory

When an object is created using `new`, memory for the object is allocated on the heap. A local reference variable usually exists in the method's stack frame and refers to that object.

Example:

```java
ParkingTicket ticket =
        new ParkingTicket(101, "TN01AB1111");
```

Here, `ticket` refers to a ParkingTicket object containing ticket number 101 and the registration number.

When no reachable references remain to an object, it becomes eligible for garbage collection. Garbage collection timing is not guaranteed.

## 7. Alternative Concept: Setters and Static Factory Methods

### Setter-based creation

An object can be created using a no-argument constructor and then initialized using setters. However, the object may temporarily contain incomplete or invalid information unless validation is carefully designed.

### Static factory methods

A static factory method creates and returns an object. It can validate input and make the creation process clearer.

### Comparison

| Approach | Advantage | Limitation |
|---|---|---|
| Parameterized constructor | Initializes required data immediately | Many parameters may become difficult to manage |
| Constructor chaining | Reduces duplicated initialization | Must follow constructor invocation rules |
| Default constructor with setters | Flexible for gradual initialization | May allow incomplete object states |
| Static factory method | Can validate data and give descriptive method names | Requires a factory method to be implemented |

Creating n ticket objects takes O(n) total time under constant-time initialization, and the objects require O(n) total space. These are asymptotic estimates and exclude any additional work performed by validation or lookup operations.

## 8. Conclusion

Constructors initialize parking-system objects and help maintain valid object states. Constructor overloading and chaining reduce repeated code. Private fields and controlled initialization improve reliability, while garbage collection manages objects that are no longer reachable.

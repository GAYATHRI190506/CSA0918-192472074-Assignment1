# TASK 5 – Apply Static Members and the Object Life Cycle

## 1. Aim

To identify class-level data and behaviour, use static members appropriately, and understand the life cycle of parking-ticket objects.

## 2. Static Variables

A static variable belongs to the class rather than to each individual object. All instances of that class share the same static variable.

In the parking system, a ticket counter can be static so that each new ticket receives a unique number.

Example:

```java
class ParkingTicket {
    private static long nextTicketNumber = 1;

    private final long ticketNumber;

    ParkingTicket() {
        ticketNumber = nextTicketNumber++;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }
}
```

Here, `nextTicketNumber` is shared by all ParkingTicket objects. Every newly created ticket receives the current value, and the counter is then incremented.

## 3. Static Methods and Static Blocks

A static method belongs to the class and can be called without creating an object. For example, a utility method that validates a registration number could be static if it does not depend on instance data.

A static initialization block runs once when the class is initialized. It is useful for initializing class-level data that requires more than a simple assignment. A static block is not necessary when a straightforward field initializer is sufficient.

## 4. Object Life Cycle

A ParkingTicket object is created when the program issues a ticket for an entering vehicle.

When the vehicle exits, the ticket can be marked as closed and removed from the collection of active tickets. The ticket object may still be retained in a history collection for reporting.

If no reachable references remain to the ticket object, it becomes eligible for garbage collection. Eligibility does not mean the object is collected immediately.

## 5. Passing and Returning Objects

Java passes arguments by value. When an object is passed to a method, the value of its reference is passed.

A method can use that reference to access or modify the object's state, subject to the class's access rules. A method can also return an object reference.

For example:

```java
ParkingTicket createTicket() {
    return new ParkingTicket();
}
```

The returned reference allows the calling code to access the newly created ticket.

## 6. Alternative Concept: Instance Counter

If the ticket counter were an instance variable, every ParkingFacility object would have its own counter.

For example, a north-gate facility and a south-gate facility could both issue ticket number 1. This may be acceptable if ticket numbers are unique only within each facility, but it is unsuitable if the university requires globally unique ticket numbers.

### Possible solutions

- Use a static counter when all facilities share one counter within a single application and class-loading context.
- Use a counter stored in a central ticket service.
- Use a persistent database sequence or another coordinated identifier generator when multiple application instances must issue unique tickets.

### Complexity and space comparison

Let k be the number of facility objects and n be the number of issued tickets.

| Counter design | Space for the counter | Ticket-number generation |
|---|---|---|
| Static counter | O(1) shared counter | O(1) per increment |
| Instance counter | O(k), one counter per facility | O(1) per increment |

If each issued ticket is also stored, the ticket objects require additional O(n) space. A static counter alone does not guarantee global uniqueness across separate application processes or independently running servers.

## 7. Conclusion

Static members are suitable for data shared by all instances, such as a simple ticket counter. Instance variables represent data specific to individual objects. Understanding references and garbage collection helps manage the life cycle of tickets and other parking-system objects.


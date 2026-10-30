# TASK 1 – Understand the Problem and Identify the Objects

## 1. Aim

To analyse the Campus Smart-Parking System, identify its inputs and outputs, determine the candidate classes and their responsibilities, and define the business rules and assumptions required for a correct object-oriented design.

## 2. Problem Analysis

The university has a multi-level parking facility with numbered slots on each floor. It supports two-wheelers, cars and electric vehicles. When a vehicle enters, the system must find a suitable free slot, issue a unique parking ticket and record the entry time. When the vehicle leaves, the system must calculate the parking fee and release the slot.

Students and staff with valid monthly passes park free of charge, while visitors pay the full parking fee. The design should also support future vehicle categories and new pricing rules without unnecessary changes to existing classes.

## 3. Inputs and Outputs

### Inputs
- Vehicle registration number
- Vehicle category
- Floor and slot information
- Vehicle entry time and exit time
- User category (student, staff or visitor)
- Monthly-pass validity
- Number of floors and slots on each floor

### Outputs
- Allocated floor and slot number
- Unique parking ticket number
- Vehicle entry and exit details
- Parking duration
- Calculated parking fee
- Slot availability and occupancy information
- Error messages for invalid operations or a full parking facility

## 4. Candidate Classes and Their Responsibilities

| Candidate Class | Responsibilities | Justification |
|---|---|---|
| Vehicle | Store registration details and define common vehicle behaviour | Represents each vehicle as an independent object |
| TwoWheeler | Represent a two-wheeler and its applicable rate | Allows vehicle-specific behaviour |
| Car | Represent a car and its applicable rate | Separates car-specific behaviour |
| ElectricCar | Represent an electric car and charging capability | Supports charging-related operations |
| ParkingSlot | Represent a slot and its occupancy status | Helps prevent a slot from being occupied by multiple vehicles |
| ParkingTicket | Store ticket number, vehicle, entry time and slot details | Maintains a record of each parking session |
| ParkingFacility | Manage floors, slots, allocation and release operations | Centralizes parking-space management |
| ParkingPass | Represent pass validity and eligibility | Supports free parking for eligible students and staff |
| ParkingFeeCalculator | Calculate parking charges according to the applicable rules | Separates billing logic from slot management |

These are candidate classes. The final implementation may combine or separate responsibilities based on the design requirements.

## 5. Nouns and Verbs

### Nouns that become candidate classes or attributes
- Vehicle
- Car
- Two-wheeler
- Electric vehicle
- Parking facility
- Floor
- Slot
- Ticket
- Parking pass
- Parking fee

### Verbs that become methods
- Allocate a slot
- Release a slot
- Issue a ticket
- Record entry time
- Calculate a fee
- Validate a pass
- Find a free slot
- Register a vehicle
- Process vehicle exit

Examples of method names are `allocateSlot()`, `releaseSlot()`, `issueTicket()`, `calculateFee()` and `validatePass()`.

## 6. Business Rules

1. A parking slot cannot hold more than one vehicle at a time.
2. A vehicle must be assigned only to a suitable, available slot.
3. A ticket number must be unique and must not be reused.
4. A vehicle must have a valid registration number.
5. An exit operation must not release an invalid or already-free slot.
6. The parking fee must depend on the vehicle category and parking duration.
7. Students and staff with valid monthly passes receive free parking under the original requirements.
8. Visitors without an applicable pass pay the full parking fee.
9. A vehicle cannot exit through an active parking ticket that does not belong to it.
10. When no suitable slot is available, the system must reject the allocation safely.

## 7. Assumptions

1. Each vehicle has a unique registration number.
2. The facility's floor and slot capacities are configured before parking operations begin.
3. Entry and exit times are recorded using a consistent time representation.
4. The exact hourly rates and billing slabs will be defined in the implementation.
5. Parking duration cannot be negative.
6. Monthly passes are checked for validity before applying a free-parking benefit.
7. Electric-vehicle charging fees, if applicable, are calculated separately from ordinary parking charges.
8. The initial implementation uses a single active parking session per vehicle.

## 8. Alternative Concept: Parallel Arrays Instead of Objects

Instead of representing each vehicle as an object, the system could store registration numbers, vehicle categories and entry times in separate arrays.

Example:

```java
String[] regNo = new String[100];
String[] type = new String[100];
long[] entryTime = new long[100];
```

Each vehicle's information must be stored at the same array index. For example, `regNo[0]`, `type[0]` and `entryTime[0]` describe the same vehicle.

### Comparison

| Feature | Object-Oriented Design | Parallel Arrays |
|---|---|---|
| Vehicle representation | One Vehicle object contains related data and behaviour | Related information is stored in separate arrays |
| Search by registration number | Linear search takes O(n) without an additional index | Linear search takes O(n) |
| Adding a new attribute | Add a field and appropriate behaviour to the class | Add another array and keep all indices synchronized |
| Data organization | Related data and methods are grouped together | Data is distributed across several arrays |
| Maintenance | Easier to extend using classes and inheritance | More error-prone as the number of attributes increases |
| Space | O(n) overall, including object and reference overhead | O(n) overall, with separate arrays |

Here, n is the number of stored vehicles. Both approaches require O(n) time for a straightforward registration-number search. The object-oriented approach is easier to extend because vehicle data and behaviour are grouped together.

## 9. Conclusion

The Campus Smart-Parking System can be designed using classes that separate vehicle information, parking-space management, ticket management and fee calculation. Encapsulation and clear class responsibilities help protect the system's business rules. An object-oriented design is preferred over parallel arrays because it is easier to maintain and extend when new vehicle categories and pricing rules are introduced.

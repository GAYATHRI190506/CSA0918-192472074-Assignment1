# Task 11: Complete Parking System Implementation

## 1. Objective

To implement a working Campus Smart-Parking System using Java object-oriented programming concepts.

## 2. Classes Implemented

| Class | Responsibility |
|---|---|
| `Vehicle` | Stores registration details and defines fee calculation behavior. |
| `TwoWheeler` | Calculates parking fees at ₹10 per started hour. |
| `Car` | Calculates parking fees at ₹30 per started hour. |
| `ParkingTicket` | Generates ticket numbers and stores parking duration and fee. |
| `ParkingFacility` | Allocates slots, removes vehicles, and displays vehicles and tickets. |
| `Main` | Creates objects and demonstrates the complete program. |

## 3. Implementation

The system uses inheritance through the `Vehicle` superclass and its subclasses. The `calculateFee()` method uses the vehicle's hourly rate to calculate parking charges. Encapsulation protects vehicle and ticket data, while `ParkingFacility` manages parking slots and ticket records.

## 4. Test Results

| Test case | Input | Expected result | Actual result |
|---|---|---|---|
| Park a two-wheeler | 60 minutes | Fee ₹10 | Passed |
| Park a car | 130 minutes | Fee ₹90 | Passed |
| Allocate slots | Two vehicles, capacity 3 | Slots 1 and 2 allocated | Passed |
| Display tickets | Two parked vehicles | Two tickets displayed | Passed |
| Remove a vehicle | Registration `TN01A1234` | Vehicle removed from slot 1 | Passed |

## 5. Complexity Analysis

Let \(S\) be the number of parking slots and \(T\) the number of tickets.

- Parking allocation: \(O(S)\) in the worst case.
- Vehicle removal: \(O(S)\) in the worst case.
- Displaying parked vehicles: \(O(S)\).
- Displaying tickets: \(O(T)\).
- Fee calculation: \(O(1)\).

## 6. Conclusion

The program compiled and executed successfully. It demonstrates inheritance, encapsulation, runtime polymorphism, ticket generation, fee calculation, parking allocation, and vehicle removal. The implementation provides the foundation for extending the system with multiple floors and additional vehicle categories.
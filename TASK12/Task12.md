# Task 12: Advanced Campus Smart-Parking System

## 1. Objective

To extend the Campus Smart-Parking System by implementing multiple parking floors, different vehicle categories, special parking fees, and visitor passes.

## 2. Five-Floor Parking Structure

The system contains five floors with different slot capacities.

| Floor | Number of slots |
|---|---:|
| Floor 1 | 2 |
| Floor 2 | 3 |
| Floor 3 | 4 |
| Floor 4 | 2 |
| Floor 5 | 5 |
| **Total** | **16** |

A two-dimensional array stores the parked vehicles on each floor.

## 3. Additional Vehicle Categories

| Vehicle | Parking fee |
|---|---|
| Car | ₹30 per started hour |
| Two-wheeler | ₹10 per started hour |
| Electric bike | Flat fee of ₹25 |
| Delivery van | Double the car rate during the specified daytime period |

## 4. Delivery Van Pricing

Delivery vans are charged twice the normal car rate between 9:00 AM and 5:00 PM.

- Normal car rate: ₹30 per hour.
- Daytime delivery van rate: ₹60 per hour.
- Outside the daytime period: ₹30 per hour.

The system uses Java's LocalTime class to check the entry time.

## 5. Visitor Pass

The VisitorPass class generates a unique pass number and stores the visitor's name and issue date.

A visitor pass is valid only on its issue date, providing one-day access.

## 6. Object-Oriented Concepts Used

- Inheritance: Car, TwoWheeler, ElectricBike, and DeliveryVan extend Vehicle directly or through Car.
- Abstraction: Vehicle defines common vehicle behavior.
- Polymorphism: Different vehicle types implement their own fee calculation.
- Encapsulation: Private fields protect vehicle and ticket information.
- Static members: Ticket and visitor pass numbers are generated sequentially.

## 7. Test Cases

| Test | Input | Expected result |
|---|---|---|
| Car parking | 120 minutes, 10 AM | ₹60 |
| Two-wheeler parking | 60 minutes | ₹10 |
| Electric bike | 180 minutes | ₹25 |
| Delivery van | 120 minutes, 10 AM | ₹120 |
| Visitor pass | Current issue date | Valid |
| Multiple-floor allocation | Four vehicles | Four available slots allocated |

## 8. Complexity Analysis

Let S represent the total number of parking slots.

- Parking allocation: O(S) in the worst case.
- Vehicle removal: O(S) in the worst case.
- Displaying parked vehicles: O(S).
- Fee calculation: O(1).
- Visitor pass validation: O(1).

## 9. Conclusion

The advanced Campus Smart-Parking System supports five floors, multiple vehicle categories, time-based parking charges, and one-day visitor passes. It demonstrates practical applications of Java object-oriented programming concepts and provides a foundation for a scalable parking management system.
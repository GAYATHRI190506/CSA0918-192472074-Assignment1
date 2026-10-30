# TASK 2 – Choose the Data Representation

## 1. Aim

To select suitable Java data types and array structures for representing parking floors, slots, vehicles, entry times, parking durations and fees.

## 2. Choice of Data Types

| Data | Java data type | Reason |
|---|---|---|
| Floor index | int | Represents a whole-number index |
| Slot index | int | Represents a whole-number index |
| Vehicle registration number | String | Contains letters and digits |
| Vehicle category | String or enum | Represents a predefined vehicle type |
| Entry time | LocalDateTime | Stores the date and time of entry |
| Exit time | LocalDateTime | Stores the date and time of exit |
| Parking duration | long | Can store duration in minutes |
| Parking fee | double or BigDecimal | Represents monetary calculations; BigDecimal is preferable for precise currency calculations |
| Ticket number | long | Supports a growing sequence of ticket identifiers |
| Pass validity | boolean | Indicates whether a pass is valid |

## 3. Representation of Floors and Slots

A jagged two-dimensional array is suitable when floors contain different numbers of slots.

Example:

```java
String[][] slots = {
    new String[20],
    new String[50],
    new String[100]
};
```

Each row represents one floor. Each element stores a vehicle registration number, while `null` indicates a free slot.

The number of floors is `slots.length`. The number of slots on floor `f` is `slots[f].length`.

This representation supports different slot capacities on different floors without allocating unnecessary unused positions.

## 4. Type Conversion and Precision

Parking duration can be calculated in minutes using a time API such as `Duration`. If every started hour is charged in full, billable hours can be calculated using integer arithmetic:

```java
long minutes = 130;
long hours = (minutes + 59) / 60;
```

The result is 3 hours.

Using `minutes / 60` would produce 2 because integer division discards the fractional part. That would calculate the fee incorrectly.

For example, if the hourly rate is ₹30:

- Incorrect calculation: 2 × ₹30 = ₹60
- Correct calculation: 3 × ₹30 = ₹90

For monetary values, BigDecimal can avoid common floating-point rounding issues. The billing rule must be clearly defined before applying rounding.

## 5. Reading Input

The Scanner class can read input from the keyboard.

Example:

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);

System.out.print("Enter vehicle registration number: ");
String regNo = sc.nextLine();

System.out.print("Enter vehicle category: ");
String vehicleType = sc.nextLine();
```

Scanner is suitable for an interactive program because it allows the user to enter vehicle information during execution.

## 6. Alternative Representations and Complexity

### A. Jagged array

`String[][] slots` allows every floor to have its own slot capacity.

### B. One-dimensional array

A single array can represent all slots if a mapping from floor and slot to a global index is maintained.

For equal-sized floors:

`index = floor * slotsPerFloor + slot`

For floors with different capacities, this formula must be adjusted using the total number of slots on earlier floors, or an offset array must be maintained.

### C. ArrayList of arrays

`ArrayList<String[]>` can store one array for each floor and can be useful when the number of floors changes dynamically.

### Complexity comparison

| Operation | Jagged array | One-dimensional array with mapping | ArrayList of floor arrays |
|---|---|---|---|
| Locate a specific slot by its coordinates | O(1) | O(1) with correct offsets | O(1) |
| Scan for the first free slot | O(S) in the worst case | O(S) in the worst case | O(S) in the worst case |
| Space | O(S) | O(S) | O(S), plus list overhead |

Here, S is the total number of parking slots. All three approaches require space proportional to the total number of slots. The jagged array is selected because it directly represents floors with different capacities.

## 7. Conclusion

Suitable Java data types improve correctness and clarity. A jagged array is appropriate for floors with different slot counts. Integer arithmetic with ceiling division prevents incorrect billing when every started hour is charged in full. Scanner supports interactive input, while suitable monetary types help maintain accurate fee calculations.

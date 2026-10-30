# TASK 3 – Design the Control Logic

## 1. Allocation Pseudocode

**Input:** Vehicle registration number  
**Output:** Floor and slot indices, or null if full

1. START
2. FOR each floor
3.   FOR each slot on that floor
4.     IF the slot is empty
5.       Store the vehicle registration number
6.       RETURN the floor and slot indices
7.     END IF
8.   END FOR
9. END FOR
10. RETURN null
11. STOP

## 2. Release Pseudocode

**Input:** Floor index and slot index  
**Output:** true if released; otherwise false

1. START
2. IF the floor index is invalid, RETURN false
3. IF the slot index is invalid, RETURN false
4. IF the slot is already empty, RETURN false
5. Set the slot to null
6. RETURN true
7. STOP

## 3. Parking Fee Pseudocode

**Input:** Parking duration in minutes and hourly rate  
**Output:** Parking fee

1. START
2. IF the duration is negative, reject the input
3. Calculate billable hours by rounding every started hour up
4. Multiply billable hours by the hourly rate
5. RETURN the calculated fee
6. STOP

**Assumption:** Every started hour is charged in full, as specified in the supplied FeeDemo program. Zero-minute parking is charged zero under this rule.

## 4. Explanation of the Methods

### allocate()

The method searches the parking facility floor by floor and slot by slot. When it finds an empty slot, it stores the vehicle registration number and returns the slot coordinates. If no free slot exists, it returns null.

### release()

The method checks the floor index, slot index and occupancy status. If the position is valid and occupied, it sets the slot to null and returns true. Otherwise, it returns false.

## 5. Time Complexity

Let S be the total number of parking slots.

| Method | Worst-case time complexity | Reason |
|---|---|---|
| allocate() | O(S) | May inspect every slot |
| release() | O(1) | Checks one specified slot |

The auxiliary space used by each operation is O(1), excluding the parking array maintained by the facility.

## 6. Expected Program Output

```text
[0, 0]
[0, 1]
[1, 0]
null
true false false
[0, 1]
```

## 7. Conclusion

The allocation method finds the first available parking slot, while the release method validates and frees a specified slot. The program handles a full facility and invalid release operations safely.

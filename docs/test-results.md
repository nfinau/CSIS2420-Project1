# Test Results – CSIS2430 Project 1

This document records verification evidence comparing expected vs actual output.

Verification Lead should:
1) Pull latest repo
2) Run program using README instructions
3) Compare console output exactly to expectations
4) Record PASS/FAIL and notes

---

## Environment
Language: Java
Run Command:
javac src/Main.java
java -cp src Main

---

# TEST CASE 1 — Provided Sample Data

## Purpose
Verify all ordinary set operations and multiset operations execute and are labeled correctly.

## Expected Output Sections (must ALL appear)

PART 1:
- A
- B
- A U B
- A ∩ B
- A - B
- NOT(A)
- A XOR B

PART 2:
- Bag A
- Bag B
- A U B (max count)
- A ∩ B (min count)
- A - B (subtract, floor 0)
- A + B (sum counts)

## Actual Output
=== PART 1: Ordinary Sets ===

--- A ---
Bit string: 1010101001
Elements: Apple, Cherry, Elderberry, Grape, Lemon

--- B ---
Bit string: 0110010100
Elements: Banana, Cherry, Fig, Honeydew

--- A U B ---
Bit string: 1110111101
Elements: Apple, Banana, Cherry, Elderberry, Fig, Grape, Honeydew, Lemon

--- A n B ---
Bit string: 0010000000
Elements: Cherry

--- A - B ---
Bit string: 1000101001
Elements: Apple, Elderberry, Grape, Lemon

--- NOT(A) ---
Bit string: 0101010110
Elements: Banana, Date, Fig, Honeydew, Kiwi

--- A XOR B ---
Bit string: 1100111101
Elements: Apple, Banana, Elderberry, Fig, Grape, Honeydew, Lemon

=== PART 2: Multisets (Bags) ===

Bag A:
Counts: [2, 0, 1, 0, 3, 0, 1, 0, 0, 2]
Elements: Apple(2), Cherry(1), Elderberry(3), Grape(1), Lemon(2)

Bag B:
Counts: [1, 1, 0, 2, 1, 0, 0, 3, 0, 1]
Elements: Apple(1), Banana(1), Date(2), Elderberry(1), Honeydew(3), Lemon(1)

A U B (max count):
Counts: [2, 1, 1, 2, 3, 0, 1, 3, 0, 2]
Elements: Apple(2), Banana(1), Cherry(1), Date(2), Elderberry(3), Grape(1), Honeydew(3), Lemon(2)

A n B (min count):
Counts: [1, 0, 0, 0, 1, 0, 0, 0, 0, 1]
Elements: Apple(1), Elderberry(1), Lemon(1)

A - B (subtract, floor 0):
Counts: [1, 0, 1, 0, 2, 0, 1, 0, 0, 1]
Elements: Apple(1), Cherry(1), Elderberry(2), Grape(1), Lemon(1)

A + B (sum counts):
Counts: [3, 1, 1, 2, 4, 0, 1, 3, 0, 3]
Elements: Apple(3), Banana(1), Cherry(1), Date(2), Elderberry(4), Grape(1), Honeydew(3), Lemon(3)

## Result
PASS

## Notes
(Describe any mismatch in labels, order, or formatting)

---

# TEST CASE 2 — Edge Case: Empty Sets

## Setup
All boolean values false
All bag counts 0

## Expected
- Prints "(empty set)" for sets
- Prints "(empty bag)" for multisets
- No crashes or exceptions

## Actual Output
=== PART 1: Ordinary Sets ===

--- A ---
Bit string: 0000000000
Elements: (empty set)

--- B ---
Bit string: 0000000000
Elements: (empty set)

--- A U B ---
Bit string: 0000000000
Elements: (empty set)

--- A n B ---
Bit string: 0000000000
Elements: (empty set)

--- A - B ---
Bit string: 0000000000
Elements: (empty set)

--- NOT(A) ---
Bit string: 1111111111
Elements: Apple, Banana, Cherry, Date, Elderberry, Fig, Grape, Honeydew, Kiwi, Lemon

--- A XOR B ---
Bit string: 0000000000
Elements: (empty set)

=== PART 2: Multisets (Bags) ===

Bag A:
Counts: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Elements: (empty bag)

Bag B:
Counts: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Elements: (empty bag)

A U B (max count):
Counts: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Elements: (empty bag)

A n B (min count):
Counts: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Elements: (empty bag)

A - B (subtract, floor 0):
Counts: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Elements: (empty bag)

A + B (sum counts):
Counts: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Elements: (empty bag)

## Result
PASS 

## Notes

---

# TEST CASE 3 — Edge Case: Full Sets

## Setup
All boolean values true
All bag counts > 0

## Expected
- All elements listed
- Intersection equals full set
- Complement equals empty set
- Multiset operations produce correct counts

## Actual Output
=== PART 1: Ordinary Sets ===

--- A ---
Bit string: 1111111111
Elements: Apple, Banana, Cherry, Date, Elderberry, Fig, Grape, Honeydew, Kiwi, Lemon

--- B ---
Bit string: 1111111111
Elements: Apple, Banana, Cherry, Date, Elderberry, Fig, Grape, Honeydew, Kiwi, Lemon

--- A U B ---
Bit string: 1111111111
Elements: Apple, Banana, Cherry, Date, Elderberry, Fig, Grape, Honeydew, Kiwi, Lemon

--- A n B ---
Bit string: 1111111111
Elements: Apple, Banana, Cherry, Date, Elderberry, Fig, Grape, Honeydew, Kiwi, Lemon

--- A - B ---
Bit string: 0000000000
Elements: (empty set)

--- NOT(A) ---
Bit string: 0000000000
Elements: (empty set)

--- A XOR B ---
Bit string: 0000000000
Elements: (empty set)

=== PART 2: Multisets (Bags) ===

Bag A:
Counts: [7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
Elements: Apple(7), Banana(7), Cherry(7), Date(7), Elderberry(7), Fig(7), Grape(7), Honeydew(7), Kiwi(7), Lemon(7)

Bag B:
Counts: [7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
Elements: Apple(7), Banana(7), Cherry(7), Date(7), Elderberry(7), Fig(7), Grape(7), Honeydew(7), Kiwi(7), Lemon(7)

A U B (max count):
Counts: [7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
Elements: Apple(7), Banana(7), Cherry(7), Date(7), Elderberry(7), Fig(7), Grape(7), Honeydew(7), Kiwi(7), Lemon(7)

A n B (min count):
Counts: [7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
Elements: Apple(7), Banana(7), Cherry(7), Date(7), Elderberry(7), Fig(7), Grape(7), Honeydew(7), Kiwi(7), Lemon(7)

A - B (subtract, floor 0):
Counts: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Elements: (empty bag)

A + B (sum counts):
Counts: [14, 14, 14, 14, 14, 14, 14, 14, 14, 14]
Elements: Apple(14), Banana(14), Cherry(14), Date(14), Elderberry(14), Fig(14), Grape(14), Honeydew(14), Kiwi(14), Lemon(14)


## Result
PASS

## Notes

---

# TEST CASE 4 — Order Consistency

## Purpose
Verify elements appear in UNIVERSAL SET ORDER

Expected Order:
Apple, Banana, Cherry, Date, Elderberry, Fig, Grape, Honeydew, Kiwi, Lemon

## Actual
Bit string: 1111111111
Elements: Apple, Banana, Cherry, Date, Elderberry, Fig, Grape, Honeydew, Kiwi, Lemon

## Result
PASS 

---

# FINAL VERIFICATION SUMMARY

Overall Result:
PASS 

Verified By: Bryant Gonzalez
(Verification Lead)

Date: 2026-02-25


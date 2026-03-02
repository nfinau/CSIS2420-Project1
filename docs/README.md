# CSIS 2430 – Project 1  
## Sets, Multisets, and Natural-Language Data Queries

### Overview
This project implements ordinary sets and multisets (bags) in Java.  
It demonstrates how different mathematical structures affect operations such as union, intersection, difference, complement, and symmetric difference.

Part 1 focuses on ordinary sets represented using boolean arrays and bit strings.  
Part 2 focuses on multisets represented using integer count arrays.


## Project Structure
CSIS2430-Project1-main
-> src/Main.java & TestHarness.java
-> docs/ proj_1_palan.md & proj_1_scope.md & proj_1_pseudocode.md & test-results.md & UML Class Diagram 


## How to Compile and Run

### Compile (from project root)
javac src/Main.java  
javac src/TestHarness.java  

### Run Main Program
java -cp src Main  
This will display:
- PART 1: Ordinary Set Operations  
- PART 2: Multiset (Bag) Operations


### Run Test Harness
java -cp src TestHarness  
All verification results are recorded in:
docs/test-results.md  


## Universal Set Order
All output follows this universal element order:
Apple, Banana, Cherry, Date, Elderberry, Fig, Grape, Honeydew, Kiwi, Lemon  


## Verification Summary
All test cases passed successfully.

- Sample Case – PASS  
- Empty Sets – PASS  
- Full Sets – PASS  
- Order Consistency – PASS  

See docs/test-results.md for full verification details.


## Course
CSIS 2430 – Data Structures  
Spring 2026

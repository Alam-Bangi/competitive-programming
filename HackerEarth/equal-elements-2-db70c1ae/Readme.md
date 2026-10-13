# Equal Elements 🪙

## Problem Description
You are given an integer array `A` consisting of `N` elements. You can perform the following operations on array `A`:
* Choose any element and increase or decrease it by **3** for **1 coin**.
* Choose any element and increase or decrease it by **2** for **free**.

The task is to find the **minimum number of coins** required to make all the elements of the array equal.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Basic Programming / Bit Manipulation / Basics of Bit Manipulation
* **Difficulty:** Easy
* **Problem Link:** [Equal elements](https://hackerearth.com)

---

## Method / Approach
The problem can be efficiently solved using a **Parity Check (Odd/Even counting)** approach:

1. **Parity Preservation:** Adding or subtracting `2` is free and **does not change the parity** (evenness or oddness) of a number. This means you can transform any even number into any other even number, and any odd number into any other odd number, completely for free.
2. **Parity Modification:** Adding or subtracting `3` costs `1` coin and **flips the parity** of the number (even becomes odd, and odd becomes even).
3. **Optimisation:** 
   * To make all numbers **even**, we must flip all the odd numbers once, costing `1 coin` per odd number. Total cost = `oddCount`.
   * To make all numbers **odd**, we must flip all the even numbers once, costing `1 coin` per even number. Total cost = `evenCount`.
4. **Result:** The minimum cost will simply be `Math.min(evenCount, oddCount)`.

---

## Solution

### Java (Java 8)

```java
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int evenCount = 0;
            int oddCount = 0;
            
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }            
            System.out.println(Math.min(evenCount, oddCount));
        }        
        sc.close();
    }
}

```


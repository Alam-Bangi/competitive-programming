# Largest Number

- **Platform:** HackerEarth
- **Difficulty:** Easy / Medium
- **Track:** Basic Programming / Implementation / Basics of Implementation
- **Problem Link:** [Largest Number](https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/largest-number-10-ca319b09/)

## Problem Description

Given an integer $N$ which has $D$ digits, your task is to **delete exactly $K$ digits** from the integer $N$. Find out the **largest possible number** that can be built from the remaining digits of $N$ without changing their relative original positions.

## Approach

This problem can be optimally solved using a **Greedy Approach** with a **Monotonic Stack**:

1. **Greedy Traversal:** To form the largest possible number, we want larger digits to appear as far left (at higher place values) as possible.
2. **Maintaining a Monotonic Stack:** 
   - Iterate through each digit of the number from left to right.
   - While the current digit is greater than the digit at the top of the stack and we still have operations left ($K > 0$), pop the smaller digit from the stack and decrement $K$.
   - Push the current digit onto the stack.
3. **Handling Remaining Deletions:** If we finish traversing the digits but still have deletions left ($K > 0$), remove the remaining digits from the end of the stack (since the stack is now in non-increasing order).
4. **Build the Result:** Construct the final string from the elements remaining in the stack.

## Solution (Java 8)

```java
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int k = sc.nextInt();
        sc.close();

        Set<String> currentSet = new HashSet<>();
        currentSet.add(number);

        for (int step = 0; step < k; step++) {
            Set<String> nextSet = new HashSet<>();
            for (String s : currentSet) {
                for (int i = 0; i < s.length(); i++) {
                    String modified = s.substring(0, i) + s.substring(i + 1);
                    nextSet.add(modified);
                }
            }
            currentSet = nextSet;
        }

        int maxNum = 0;
        for (String s : currentSet) {
            int val = Integer.parseInt(s);
            if (val > maxNum) {
                maxNum = val;
            }
        }

        System.out.println(maxNum);
    }
}
```


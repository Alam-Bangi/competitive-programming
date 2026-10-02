# Signaling 📡

## Problem Description

You are given a binary string of length `N`. A character at the `i-th` position signifies the signal level of an antenna at the `i-th` second. 
* `0` represents a **low signal**.
* `1` represents a **high signal**.

The task is to find the **maximum consecutive time (in seconds) for which the signal was high**.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Algorithms / Greedy Algorithms / Basics of Greedy Algorithms
* **Difficulty:** Easy
* **Problem Link:** [Signaling](https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/signaling-07a313d7/)

---

## Method / Approach

A **Greedy / Linear Scan** approach solves this efficiently in O(N) time complexity and O(1) auxiliary space complexity:

1. **Iterative Counting:** Traverse the binary string character by character. 
2. **Track Current Streak:** If the character is `'1'`, increment the current consecutive counter.
3. **Reset and Maximize:** If the character is `'0'`, update the global maximum value with the current counter if it is larger, then reset the current consecutive counter back to `0`.
4. **Final Check:** After the loop concludes, do one last comparison to check if the final streak at the end of the string is the maximum.

---

## Solution (Java 8)

```java
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                String s = sc.next();
                
                System.out.println(solve(n, s));
            }
        }
    }
    public static int solve(int n, String s) {
        int maxContinuos = 0;
        int currentCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                currentCount++;
                if (currentCount > maxContinuos) {
                    maxContinuos = currentCount;
                }
            } else {
                currentCount = 0;
            }
        }        
        return maxContinuos;
    }
}

```


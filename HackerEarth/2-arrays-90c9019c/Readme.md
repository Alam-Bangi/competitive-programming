# 2 Arrays 🔢

## Problem Description

**You are given two arrays** $A$ and $B$, each of size $N$. Each element in these arrays is either a positive integer or $-1$. The total number of $-1$'s appearing across both arrays is either $1$ or $2$.

Your task is to find the number of ways to replace each $-1$ with a non-negative integer ($0, 1, 2, \dots$) such that the total sum of array $A$ equals the total sum of array $B$. If there are infinitely many ways, print `Infinite`.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Data Structures / Arrays / 1-D
- **Difficulty:** Easy
- **Problem Link:** [2 arrays](https://www.hackerearth.com/community/problem/algorithm/2-arrays-90c9019c)

---

## Method / Approach

The problem can be solved in **O(N) time** by calculating the sum of known elements and counting the occurrences of $-1$ in each array.

1. **Read the Input:** Read the array size $N$, followed by the $N$ elements of array $A$ and $N$ elements of array $B$.
2. **Calculate Sums and Counts:** 
   - Compute `sumA` (sum of positive elements in $A$) and `countA` (number of $-1$'s in $A$).
   - Compute `sumB` (sum of positive elements in $B$) and `countB` (number of $-1$'s in $B$).
3. **Evaluate Cases:**
   - **Case 1 (`countA == 1` and `countB == 1`):** Both arrays have one $-1$. Since any non-negative value added to the smaller sum can be matched by adding the difference to the larger sum, there are **`Infinite`** ways.
   - **Case 2 (`countA == 1` and `countB == 0`, or vice versa):** Only one array contains $-1$. Let `diff` be the sum of the complete array minus the sum of the incomplete array. If `diff >= 0`, there is **`1`** valid way (replacing $-1$ with `diff`); otherwise, **`0`** ways.
   - **Case 3 (`countA == 2` and `countB == 0`, or vice versa):** One array has two $-1$'s ($x + y = \text{diff}$ where $x, y \ge 0$). If `diff >= 0`, the number of non-negative integer pairs is **`diff + 1`**; otherwise, **`0`** ways.

### Time and Space Complexity
- **Time Complexity:** O(N), where N is the size of each array.
- **Auxiliary Space Complexity:** O(1) if computing sums on the fly without storing the arrays.

---

## Solution

### Java (Java 8)

```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long sumA = 0;
        int countA = 0;
        for (int i = 0; i < n; i++) {
            long val = sc.nextLong();
            if (val == -1) {
                countA++;
            } else {
                sumA += val;
            }
        }
        
        long sumB = 0;
        int countB = 0;
        for (int i = 0; i < n; i++) {
            long val = sc.nextLong();
            if (val == -1) {
                countB++;
            } else {
                sumB += val;
            }
        }
        
        if (countA > 0 && countB > 0) {
            System.out.println("Infinite");
        } else if (countA == 0 && countB == 0) {
            System.out.println(sumA == sumB ? 1 : 0);
        } else if (countA > 0) {
            long diff = sumB - sumA;
            if (diff < 0) {
                System.out.println(0);
            } else if (countA == 1) {
                System.out.println(1);
            } else { 
                System.out.println(diff + 1);
            }
        } else { 
            long diff = sumA - sumB;
            if (diff < 0) {
                System.out.println(0);
            } else if (countB == 1) {
                System.out.println(1);
            } else { 
                System.out.println(diff + 1);
            }
        }        
        sc.close();
    }
}
```


# Minimum Additions ➕

## Problem Description
You are given an array `A` of size `N` consisting of positive integers. You are also given an integer `K`. You can perform the following operation as many times as needed: Add any non-negative integer to the array. 

The task is to determine the **minimum number of operations** (additions) required to make the floor of the average of the array **less than or equal to `K`**.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Data Structures / Arrays / 1-D
* **Difficulty:** Easy
* **Problem Link:** [Minimum additions](https://www.hackerearth.com/community/problem/algorithm/minimum-additions-0142ac80)

---

## Method / Approach
A **Mathematical Greedy** approach solves this problem efficiently in O(N) time complexity:

1. **Optimal Element Value:** To minimize the average while adding the fewest possible elements, we should always add the smallest possible non-negative integer, which is `0`. Adding `0` increases the array size (`N`) without increasing the `sum`.
2. **Formulating the Constraint:** If we add x elements of value `0`, the new size becomes N + x. We need:
   \[\lfloor \frac{\text{sum}}{N + x} \rfloor \leq K \implies \frac{\text{sum}}{N + x} < K + 1\]
3. **Calculating Required Size:** Rearranging the inequality to solve for the target array size yields:
   \[N + x \geq \lfloor \frac{\text{sum}}{K + 1} \rfloor + 1\]
4. **Final Step:** The minimum additions required is simply `(target size) - N`. If the initial average is already ≤ K, the answer is immediately `0`.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += sc.nextLong();
            }

            if (sum / n <= k) {
                System.out.println(0);
            } else {
                long ans = sum / (k + 1) + 1;
                System.out.println(ans - n);
            }
        }
        sc.close();
    }
}
```


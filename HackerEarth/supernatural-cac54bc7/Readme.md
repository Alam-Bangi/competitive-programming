# Supernatural 🔢

## Problem Description

**You are given an integer** $n$. A **supernatural number** is a number whose product of its digits equals $n$, and the number must **not** contain the digit `1` (or `0`). Your task is to count how many such supernatural numbers exist for the given $n$ ($1 \le n \le 100$).

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Implementation / Number Theory
- **Difficulty:** Easy / Medium
- **Problem Link:** [Supernatural](https://www.hackerearth.com/community/problem/algorithm/supernatural-cac54bc7)

---

## Method / Approach

Since $n$ is small ($1 \le n \le 100$), the problem can be solved by iterating through candidate numbers up to a safe upper bound (`1000000`) and validating each candidate:

1. **Read the Input:** Take the integer $n$ as input from the user.
2. **Iterate Over Candidates:** Loop through candidate numbers starting from `2` up to `1000000`.
3. **Extract and Validate Digits:**
   - Extract each digit using modulo (`% 10`) and integer division (`/ 10`).
   - If any digit is `0` or `1` (`digit < 2`), discard the candidate.
   - Multiply all valid digits together.
4. **Count Matches:** If the digit product equals $n$, increment the counter and print the final count.

### Time and Space Complexity
- **Time Complexity:** $O(M \times D)$, where $M$ is the search limit (`1000000`) and $D$ is the number of digits in each candidate.
- **Auxiliary Space Complexity:** $O(1)$ for storing counter and loop variables.

---

## Solution

### Java (Java8)

```java
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ways = new int[n + 1];
        ways[1] = 1;

        for (int num = 2; num <= n; num++) {
            for (int digit = 2; digit <= 9; digit++) {
                if (num % digit == 0) {
                    ways[num] += ways[num / digit];
                }
            }
        }
        System.out.println(ways[n]);
        sc.close();
    }
}
```


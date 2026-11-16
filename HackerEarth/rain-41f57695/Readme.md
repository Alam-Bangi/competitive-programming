# Rain Sound 🌧️

## Problem Description

You like the sound of rain only if the total sound falls within the inclusive range $[l, r]$ units. Every cloud produces $s$ units of sound. Given $T$ test cases ($1 \le T \le 10^5$), your task is to determine the **minimum** and **maximum** number of clouds that can produce a total sound within $[l, r]$ ($1 \le l \le r \le 10^9$, $1 \le s \le 10^9$). If no valid number of clouds exists, print `-1 -1`.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Basics of Implementation
- **Difficulty:** Easy
- **Problem Link:** [Rain sound](https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/rain-41f57695)

---

## Method / Approach

Since $l$, $r$, and $s$ can be up to $10^9$, iterating through multiples of $s$ would be too slow. Instead, we can find the minimum and maximum cloud counts directly in $O(1)$ time per test case using integer division:

1. **Read the Input:** Read the number of test cases $T$, and for each test case, read $l$, $r$, and $s$.
2. **Calculate Minimum Clouds (`minClouds`):** Find the smallest integer $k$ such that $k \times s \ge l$. Using integer ceiling division, this is computed as $(l + s - 1) / s$ (or `l / s`, incremented by `1` if `l % s != 0`).
3. **Calculate Maximum Clouds (`maxClouds`):** Find the largest integer $k$ such that $k \times s \le r$. Using integer floor division, this is simply `r / s`.
4. **Validate and Print:** If `minClouds <= maxClouds`, print `minClouds` and `maxClouds` separated by a space; otherwise, print `-1 -1`.

### Time and Space Complexity
- **Time Complexity:** $O(1)$ per test case, or $O(T)$ overall for $T$ test cases.
- **Auxiliary Space Complexity:** $O(1)$ for storing input and result variables.

---

## Solution

### Java (Java 8)

```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long s = sc.nextLong();
            
            long minClouds = (l + s - 1) / s;
            long maxClouds = r / s;
            
            if (minClouds > maxClouds) {
                System.out.println("-1 -1");
            } else {
                System.out.println(minClouds + " " + maxClouds);
            }
        }
        
        sc.close();
    }
}

```


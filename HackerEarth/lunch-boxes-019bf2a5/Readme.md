# Lunch Boxes 🍱

## Problem Description

Alice has `M` lunch boxes and there are `N` schools. The `i-th` school orders `A[i]` lunch boxes.

Alice wants to distribute lunch boxes to **as many schools as possible**.

For each school, she can either:
* Give exactly `A[i]` lunch boxes.
* Give `0` lunch boxes.

The task is to find the **maximum number of schools** that can receive lunch boxes.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Algorithms / Greedy Algorithms / Basics of Greedy Algorithms
* **Difficulty:** Easy
* **Problem Link:** [Lunch Boxes](https://www.hackerearth.com/community/problem/algorithm/lunch-boxes-019bf2a5)

---

## Method / Approach

A **Greedy + Sorting** approach solves this efficiently in `O(N log N)` time complexity:

1. **Sort the Requirements:** Sort the number of lunch boxes required by each school in ascending order.
2. **Choose Minimum Requirements First:** Start with the school requiring the fewest lunch boxes.
3. **Distribute Lunch Boxes:** If Alice has enough lunch boxes, give them to that school and reduce the available count.
4. **Stop When Not Possible:** If Alice cannot satisfy the current school's requirement, she cannot satisfy any following school because the requirements are sorted.
5. **Count Schools:** The number of schools successfully served is the answer.

---

## Solution (Java 8)

```java
import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long lunchBoxes = sc.nextLong();
            int n = sc.nextInt();

            long[] orders = new long[n];

            for (int i = 0; i < n; i++) {
                orders[i] = sc.nextLong();
            }

            Arrays.sort(orders);

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (lunchBoxes >= orders[i]) {
                    lunchBoxes -= orders[i];
                    count++;
                } else {
                    break;
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}
```
---

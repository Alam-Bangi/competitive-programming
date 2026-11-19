# Toy Box 🧸

## Problem Description

You have $N$ toys and $M$ toy boxes ($1 \le N, M \le 100$). Initially, all boxes are empty, and each box can hold at most one toy. Each toy $i$ has a price $P_i$ ($1 \le P_i \le 100$) and an assigned box number $B_i$ ($1 \le B_i \le M$). If you choose a toy, you must place it in its assigned box, making that box unavailable for any other toys. Your task is to select a subset of toys (along with their boxes) such that the **total sum of their prices is maximized**.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Algorithms / Greedy Algorithms / Basics of Greedy Algorithms
- **Difficulty:** Easy
- **Problem Link:** [Toy Box](https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/toy-box-5044b3ed)

---

## Method / Approach

Since each box $j$ ($1 \le j \le M$) can hold at most one toy, maximizing the total price simply means choosing the **most expensive toy** assigned to each box:

1. **Read the Input:** Read the number of toys $N$ and the number of boxes $M$.
2. **Track Maximum Price per Box (`maxPrice`):** Initialize an integer array `maxPrice` of size $M + 1$ with `0`s to store the highest toy price seen so far for each box.
3. **Process Each Toy:** Loop $N$ times to read each toy's price $P_i$ and assigned box $B_i$. Update `maxPrice[B_i] = Math.max(maxPrice[B_i], P_i)`.
4. **Calculate and Print Total:** Sum all values in `maxPrice` from index `1` to `M` and print the final result.

### Time and Space Complexity
- **Time Complexity:** $O(N + M)$, as we iterate once through the $N$ toys and once through the $M$ boxes.
- **Auxiliary Space Complexity:** $O(M)$ to store the maximum price for each of the $M$ boxes.

---

## Solution

### Java (Java 8)

```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 

        int[] maxPrice = new int[m + 1];

        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            int box = sc.nextInt();
            if (price > maxPrice[box]) {
                maxPrice[box] = price;
            }
        }
        long totalSum = 0;
        for (int i = 1; i <= m; i++) {
            totalSum += maxPrice[i];
        }
        System.out.println(totalSum);
        sc.close();
    }
}
```


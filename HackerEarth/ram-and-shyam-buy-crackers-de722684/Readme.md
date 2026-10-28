# Alice and Bob buy crackers 🎆

## Problem Description
**Alice and Bob want to buy firecrackers** available in the market with IDs ranging from \(1\) to \(N\). The cost of each firecracker is given as \(C_i\), and each item can be bought at most once. Bob's father agrees to provide the money under the strict condition that both children receive equal integer amounts. 

The task is to find the **number of unique, non-zero even sums** that can be formed by any subset of the firecrackers.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Basic Programming / Bit Manipulation / Basics of Bit Manipulation / Practice Problems
* **Difficulty:** Easy
* **Problem Link:** [Alice and Bob buy crackers](https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/ram-and-shyam-buy-crackers-de722684/)

### Format:
* **Input:** The first line contains an integer \(N\) representing the number of firecracker types. The second line contains \(N\) space-separated integers representing the costs \(C_1, C_2, \dots, C_n\).
* **Output:** Print a single integer representing the total number of unique valid amounts.

---

## Method / Approach
Given the small constraints (\(1 \le N \le 20\)), an exhaustive subset evaluation using **bitmasking** runs efficiently in \(O(2^N)\) time:
1. **Power Set Iteration:** Use a loop from \(1\) to \((2^N - 1)\) to represent every non-empty subset.
2. **Bitwise Checking:** For each subset, check if the \(j\)-th bit is set to include the corresponding firecracker cost.
3. **Unique Even Tracking:** If the calculated subset sum is even, insert it into a hash set to filter out duplicate values.

---

## Solution

### Java (Java 8)
```java
import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        for (int i = 0; i < n; i++) {
            int cost = sc.nextInt();
            Set<Integer> newSums = new HashSet<>();

            for (int sum : sums) {
                newSums.add(sum + cost);
            }
            sums.addAll(newSums);
        }

        int count = 0;
        for (int sum : sums) {
            if (sum > 0 && sum % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
```


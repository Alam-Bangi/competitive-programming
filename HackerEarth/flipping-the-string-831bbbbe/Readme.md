# Largest Substring 🔤

## Problem Description

You are given a binary string $S$ of length $N$ ($1 \le N \le 10^5$), where each character is either `'0'` or `'1'`. Find and print the maximum possible length of a contiguous substring in which the count of `'0'`s is strictly greater than the count of `'1'`s.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Algorithms / Searching / Binary Search
- **Difficulty:** Easy
- **Problem Link:** [Largest Substring](https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/flipping-the-string-831bbbbe/)

---

## Method / Approach

We can transform this string problem into a **prefix sum** array problem by treating `'0'` as `+1` and `'1'` as `-1`. A substring has more `'0'`s than `'1'`s if and only if the sum of its transformed values is strictly greater than $0$:

1. **Read the Input:** Read the integer $N$ and the binary string $S$.
2. **Track Prefix Sums:** Maintain a running prefix `sum` (initialized to $0$) and a hash map `firstIndex` to record the earliest index at which each negative prefix sum appears:
   - Iterate through the string from index $i = 0$ to $N - 1$.
   - Add `+1` to `sum` if `S.charAt(i) == '0'`, or `-1` if `S.charAt(i) == '1'`.
3. **Evaluate Substring Length:**
   - If `sum > 0`, the entire prefix from index $0$ to $i$ has more `'0'`s than `'1'`s, so update `maxLen = i + 1`.
   - Otherwise (`sum <= 0`), check if `sum - 1` exists in `firstIndex`. Because the prefix sum changes by $\pm 1$ at each step, the earliest occurrence of `sum - 1` guarantees the longest valid subarray ending at $i$ with a net sum of $+1$. Update `maxLen = Math.max(maxLen, i - firstIndex.get(sum - 1))`.
   - If `sum` is not already in `firstIndex`, store `(sum, i)`.
4. **Print Output:** Print `maxLen`.

### Time and Space Complexity
- **Time Complexity:** $O(N)$ to traverse the string once with $O(1)$ average-case hash map lookups.
- **Auxiliary Space Complexity:** $O(N)$ to store up to $N$ distinct prefix sums in the hash map.

---

## Solution

### Java (Java 8)

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int pref = 0;
        int ans = 0;
        Map<Integer, Integer> firstPos = new HashMap<>();
        firstPos.put(0, -1);

        for (int i = 0; i < n; i++) {
            pref += (s.charAt(i) == '0') ? 1 : -1;

            if (pref > 0) {
                ans = Math.max(ans, i + 1);
            } else if (firstPos.containsKey(pref - 1)) {
                ans = Math.max(ans, i - firstPos.get(pref - 1));
            }
            firstPos.putIfAbsent(pref, i);
        }
        System.out.println(ans);
        sc.close();
    }
}
```

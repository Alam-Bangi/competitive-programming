# Changes in a String 🔤

## Problem Description
You are given a string $S$ of characters comprising only of `'A'` and `'B'`. You can choose any index and change `'A'` to `'B'` or `'B'` to `'A'`. The task is to find the **minimum number of changes** you must make to the string such that the resulting string has all `'A'`s at the beginning, followed by all remaining `'B'`s.

Formally, the resulting string must match the format:
$$\underbrace{AAAA\dots}_{x \text{ number of } A's}\underbrace{BBBB\dots}_{n-x \text{ number of } B's}$$
where $0 \le x \le n$.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Algorithms / Greedy / Basics of Greedy Algorithms / Practice Problems
* **Difficulty:** Easy
* **Problem Link:** [Changes in a string](https://www.hackerearth.com/community/problem/algorithm/ab-string-5f6b213a)

### Format:
* **Input:** The first line contains a single integer $T$ denoting the number of test cases. For each test case, the first line contains an integer $N$ denoting the size of the string, and the second line contains the string $S$.
* **Output:** For each test case, print a single integer representing the minimum number of changes needed to format the string as required.

---

## Method / Approach
The problem can be optimally solved in **$O(N)$ time complexity** using a prefix-suffix greedy strategy:

1. **Count Total As:** First, traverse the entire string to calculate the total number of `'A'` characters present (`totalA`).
2. **Track Prefix Counts:** Iterate through the string while maintaining a running count of `'A'`s (`countA`) and `'B'`s (`countB`) encountered in the prefix up to the current split point.
3. **Calculate Changes at Split:** At any index, if we decide to split the string so that everything before it becomes `'A'` and everything after becomes `'B'`:
    * The number of `'B'`s in the prefix that need to be changed to `'A'` is `countB`.
    * The number of `'A'`s in the suffix that need to be changed to `'B'` is `totalA - countA`.
    * The total changes required at this split point is `countB + (totalA - countA)`.
4. **Track Minimum:** Maintain a global minimum variable that captures the lowest value of total changes across all possible split points (including splitting before the first index or after the last index).

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int a = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A') {
                    a++;
                }
            }
            int leftB = 0;
            int min = a;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'B') {
                    leftB++;
                } else {
                    a--;
                }
                min = Math.min(min, leftB + a);
            }
            System.out.println(min);
        }
        sc.close();
    }
}
```

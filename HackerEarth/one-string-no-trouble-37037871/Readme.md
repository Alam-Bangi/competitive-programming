# One String No Trouble 🔤

## Problem Description

A string is called a **good string** if and only if no two consecutive characters are the same (e.g., `"ab"` is good, while `"aa"` is not). Given a string $S$ ($1 \le |S| \le 2 \cdot 10^5$), your task is to find and print the **length of the longest good substring** of $S$.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Basics of Implementation
- **Difficulty:** Easy
- **Problem Link:** [One String No Trouble](https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/one-string-no-trouble-37037871)

---

## Method / Approach

Since the string length $|S|$ can be up to $2 \cdot 10^5$, checking every possible substring in $O(N^2)$ time would be too slow. Instead, we can solve this in a single pass in $O(N)$ time using a sliding streak counter:

1. **Read the Input:** Read the input string $S$.
2. **Initialize Trackers:** Start with `currentLength = 1` and `maxLength = 1` (since any single character is a valid good substring of length 1).
3. **Iterate Through the String:** Loop from index `i = 1` to `S.length() - 1`:
   - If `S.charAt(i) != S.charAt(i - 1)`, the good substring continues—increment `currentLength` and update `maxLength = Math.max(maxLength, currentLength)`.
   - If `S.charAt(i) == S.charAt(i - 1)`, the streak breaks—reset `currentLength = 1`.
4. **Print the Result:** Output `maxLength`.

### Time and Space Complexity
- **Time Complexity:** $O(N)$, where $N = |S|$ is the length of the string, as we traverse the string once.
- **Auxiliary Space Complexity:** $O(1)$ extra space beyond storing the input string.

---

## Solution

### Java (Java 8)

```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine().trim();
        if (s.isEmpty()) {
            System.out.println(0);
            sc.close();
            return;
        }

        int maxLen = 1;
        int currentLen = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 1;
            }
        }
        System.out.println(maxLen);
        sc.close();
    }
}
```

# Super Balanced Bracket 🔠

## Problem Description

**You are provided** a balanced bracket sequence consisting of opening `(` and closing `)` brackets. A **super balanced bracket** sequence is a balanced bracket sequence that follows a specific nesting structure where all opening brackets appear first, followed by all corresponding closing brackets, shaped like `((((....))))`. For example, `(())` and `((()))` are super balanced sequences, whereas `()()` and `(()())` are not because an opening bracket appears after a closing bracket.

Your task is to determine the size of the largest super balanced bracket subsequence that can be formed from the original sequence.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Implementation
- **Difficulty:** Easy
- **Problem Link:** [Super Balanced Bracket](https://www.hackerearth.com/community/problem/algorithm/superbalancedbracket-75edd495)

---

## Method / Approach

The problem can be solved in **O(N) time** by finding the optimal split point where all opening brackets on the left match all closing brackets on the right.

1. **Read the Input:** Take the number of test cases `T` and the bracket string `s` as input.
2. **Count Total Closing Brackets:** Traverse the string once to count the total number of closing brackets `)`.
3. **Find Maximum Subsequence Size:** Traverse the string again while tracking opening brackets `(` on the left and remaining closing brackets `)` on the right:
   - For each index, the valid super balanced length is `2 * min(leftOpen, rightClose)`.
   - Track the maximum length found across all positions.
4. **Print the Result:** Output the maximum size for each test case.

### Time and Space Complexity
- **Time Complexity:** O(N), where N is the length of the string.
- **Auxiliary Space Complexity:** O(1) extra space (excluding input storage).

---

## Solution

### Java (Java 8)

```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder output = new StringBuilder();
        
        while (t-- > 0) {
            String s = sc.next();
            int rightClose = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    rightClose++;
                }
            }
            
            int leftOpen = 0;
            int maxK = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    leftOpen++;
                } else {
                    rightClose--;
                }
                
                int currentK = Math.min(leftOpen, rightClose);
                if (currentK > maxK) {
                    maxK = currentK;
                }
            }   
            output.append(2 * maxK).append("\n");
        }
        System.out.print(output.toString());        
        sc.close();
    }
}

```


# Addition Errors ➕

## Problem Description

Bob is a beginner mathematician who struggles with adding numbers because he is unaware of the concept of carrying over digits. Whenever he adds two numbers, he simply ignores any carry at every digit position. For example, when adding $5$ and $8$, he writes $3$ instead of $13$; when adding $18$ and $223$, he writes $231$ instead of $241$.

Given $T$ test cases ($1 \le T \le 10^5$), compute the **error** in Bob's addition algorithm for two given integers $A$ and $B$ ($1 \le A, B \le 10^{18}$), where the error is defined as the absolute difference between the actual sum and Bob's carry-less sum.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Basics of Implementation
- **Difficulty:** Easy
- **Problem Link:** [Addition Errors](https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/addition-errors-68e27044)

---

## Method / Approach

Notice that the difference between the actual sum $(A + B)$ and Bob's carry-less sum is purely the sum of all the carry values generated at each digit position. Since $A$ and $B$ can be as large as $10^{18}$ (up to $19$ digits), we can process both numbers digit-by-digit from right to left (units place to most significant digit):

1. **Read the Input:** Read the number of test cases $T$, and for each test case, read the two numbers $A$ and $B$. Use fast I/O (`BufferedReader` or `Scanner` with `long`) because $T$ can be up to $10^5$ and $A, B \le 10^{18}$.
2. **Simulate Carry-Less Addition:**
   - Maintain a `place` multiplier starting at $1$ ($10^0, 10^1, 10^2, \dots$) and a `bobSum` initialized to $0$.
   - While $A > 0$ or $B > 0$:
     - Extract the last digits: `digitA = A % 10` and `digitB = B % 10`.
     - Add them modulo $10$ (ignoring any carry): `digitSum = (digitA + digitB) % 10`.
     - Append this digit to Bob's result: `bobSum += digitSum * place`.
     - Move to the next digit: divide $A$ and $B$ by $10$, and multiply `place` by $10$.
3. **Compute and Print the Error:** Calculate `actualSum - bobSum` (where `actualSum = origA + origB`) and print the result. *(Note: Since $A, B \le 10^{18}$, `actualSum` can reach $2 \times 10^{18}$, which safely fits inside a signed 64-bit `long` in Java, whose max value is $\approx 9.22 \times 10^{18}$.)*

### Time and Space Complexity
- **Time Complexity:** $O(\log_{10}(\max(A, B)))$ per test case (at most $19$ iterations), or $O(T \log_{10}(\max(A, B)))$ overall.
- **Auxiliary Space Complexity:** $O(1)$ for storing input and place-value variables.

---

## Solution

### Java (Java 8)

```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            long actualSum = a + b;
            long bobSum = 0;
            long place = 1;
            
            while (a > 0 || b > 0) {
                long digitSum = ((a % 10) + (b % 10)) % 10;
                bobSum += digitSum * place;
                
                a /= 10;
                b /= 10;
                place *= 10;
            }   
            long error = actualSum - bobSum;
            System.out.println(error);
        }        
        sc.close();
    }
}
```


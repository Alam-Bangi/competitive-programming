# Does it divide? ➗

## Problem Description

Consider a permutation of numbers from $1$ to $N$ written on a paper. Let $P$ denote the product of its elements ($1 \times 2 \times \dots \times N = N!$), and let $S$ denote the sum of its elements ($1 + 2 + \dots + N = \frac{N(N+1)}{2}$). Given $T$ test cases ($1 \le T \le 100$) and a positive integer $N$ ($1 \le N \le 10^9$) for each test case, your task is to determine whether $P$ is divisible by $S$ or not. If $P$ is divisible by $S$, print `YES`; otherwise, print `NO`.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Math / Number Theory / Primality Tests
- **Difficulty:** Easy
- **Problem Link:** [Does it divide?](https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/does-it-divide-3c60b8fb)

---

## Method / Approach

Since $N$ can be up to $10^9$, computing $N!$ directly is impossible due to integer overflow and time limits. Instead, we can simplify the divisibility condition mathematically:

1. **Rewrite the Ratio:** We need to check if $\frac{P}{S}$ is an integer:
   $$\frac{P}{S} = \frac{N!}{\frac{N(N+1)}{2}} = \frac{2 \cdot N!}{N(N+1)} = \frac{2 \cdot (N-1)!}{N+1}$$
2. **Analyze $(N + 1)$:**
   - **Case 1 ($N = 1$):** $P = 1$ and $S = 1$. Since $1$ divides $1$, the answer is `YES`.
   - **Case 2 ($N + 1$ is composite and $N > 1$):** If $N + 1$ is composite, it can be factored into $a \times b$ where $1 < a, b \le N$. If $a \neq b$, both factors appear distinctly in $(N-1)!$ (for $N \ge 3$). Even when $N + 1 = 4$ ($N = 3$), $2 \cdot (3-1)! = 4$, which is divisible by $4$. Thus, for all composite $N + 1$, the answer is `YES`.
   - **Case 3 ($N + 1$ is prime):** If $N + 1$ is an odd prime (since $N > 1 \implies N + 1 > 2$), none of the numbers in $2 \cdot (N-1)!$ have $(N + 1)$ as a prime factor. Therefore, $(N + 1)$ cannot divide $2 \cdot (N-1)!$, and the answer is `NO`.
3. **Check Primality:** Read $T$, and for each $N$, output `NO` if $N + 1$ is a prime number greater than $2$; otherwise, output `YES`. Checking divisibility up to $\sqrt{N + 1}$ takes $O(\sqrt{N})$ time per test case.

### Time and Space Complexity
- **Time Complexity:** $O(\sqrt{N})$ per test case, or $O(T\sqrt{N})$ overall for $T$ test cases.
- **Auxiliary Space Complexity:** $O(1)$ for storing input and loop variables.

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
            long n = sc.nextLong();
            long target = n + 1;
            boolean isPrime = true;
            
            if (target < 2) {
                isPrime = false;
            } else if (target == 2) {
                isPrime = true;
            } else if (target % 2 == 0) {
                isPrime = false;
            } else {
                for (long i = 3; i * i <= target; i += 2) {
                    if (target % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            
            if (target > 2 && isPrime) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }        
        sc.close();
    }
}
```


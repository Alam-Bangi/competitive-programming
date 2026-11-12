# Co-Prime Numbers 🔢

## Problem Description
**You are provided with a number $N$** as input. Your task is to print the total number of co-prime numbers to $N$ that are strictly less than $N$ (i.e., numbers $x$ such that $1 \le x < N$ and $\gcd(x, N) = 1$).

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Number Theory
- **Difficulty:** Easy
- **Problem Link:** [Co-prime Numbers](https://www.hackerearth.com/community/problem/algorithm/coprimed-32042ef1)

---

## Method / Approach
The problem can be solved in **$O(N \log N)$ time** using the Euclidean algorithm to check the Greatest Common Divisor (GCD).

1. **Read the Input:** Take integer $N$ as input from the user.
2. **Count Co-primes:** Iterate through each number $i$ from $1$ to $N-1$ and check if $\gcd(i, N) == 1$.
3. **Print the Result:** Increment a counter for each co-prime found and print the final count.

### Time and Space Complexity
- **Time Complexity:** $O(N \log(\min(i, N)))$, where $N$ is the input integer.
- **Auxiliary Space Complexity:** $O(1)$ constant space.

---

## Solution

### Java (Java 8)

```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        for (long a = n - 2; a >= 1; a--) {
            if (gcd(a, n) == 1) {
                System.out.println(a);
                break;
            }
        }
        sc.close();
    }
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

```


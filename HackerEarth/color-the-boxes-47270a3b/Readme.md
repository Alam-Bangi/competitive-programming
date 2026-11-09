# Color the Boxes 🎨

## Problem Description
You are given $N$ boxes kept in a straight line and $M$ distinct colors (where $M \le N$). You cannot change the position of the boxes. Determine the number of ways to color the boxes such that any selection of consecutive boxes contains unique colors. 

Since the number can be very large, print the answer modulo $10^9 + 7$.

---

## Important Notes:
- **Platform:** HackerEarth
- **Difficulty:** Easy
- **Problem Link:** [Color the boxes](https://www.hackerearth.com/community/problem/algorithm/color-the-boxes-47270a3b)

---

## Method / Approach
To ensure that any sequence of consecutive boxes has all unique colors, no two adjacent boxes can share the same color—in fact, any segment of length $M$ must use all $M$ distinct colors. 

1. **First Box:** You have $M$ choices of colors.
2. **Second Box:** You have $(M - 1)$ choices (since it cannot match the first box).
3. **General Pattern:** Each subsequent box down to the $M$-th box has one fewer choice. Once you color $M$ boxes with all $M$ distinct colors, any consecutive subsegment of length $M$ is uniquely determined or constrained.
4. **Permutation / Factorial:** The number of ways to arrange or pick the colors follows a factorial-based logic or $M!$ (permutation product modulo $10^9 + 7$). Since the $(M+1)$-th box must be different from the previous $M-1$ boxes, its choice is completely forced to be the color of the first box. Thus, the total number of valid ways is simply $M! \pmod{10^9 + 7}$.

---

## Solution (Java 8)

```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        long mod = 1000000007L;
        long ans = 1;

        for (int i = 1; i <= m; i++) {
            ans = (ans * i) % mod;
        }
        System.out.println(ans);

        sc.close();
    }
}
```


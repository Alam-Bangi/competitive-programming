# Pile of Coins 🪙

## Problem Description
Ashish and Jeel are playing a game with two piles of coins containing $P$ and $Q$ coins, respectively. They take alternate turns, starting with Ashish. During each turn, the active player chooses one pile, splits it into two non-zero parts, and discards the other pile (which cannot be used further). A player loses if they cannot make a valid move. Given $T$ test cases ($1 \le T \le 10$), determine the winner of the game if both players play optimally (`Ashish` or `Jeel`) for given pile sizes $P$ and $Q$ ($1 \le P, Q \le 10^6$).

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Basics of Implementation
- **Difficulty:** Easy
- **Problem Link:** [Pile of Coins](https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/pile-of-coins-d33de897)

---

## Method / Approach
Notice that a pile of size $1$ cannot be split into two non-zero parts, whereas any pile of size $\ge 2$ can be split into $(1, N - 1)$. By analyzing small cases, we can determine the winning strategy in $O(1)$ time without simulating the game:
1. **Read the Input:** Read the number of test cases $T$, and for each test case, read the two pile sizes $P$ and $Q$.
2. **Analyze Optimal Moves:**
   - If **both** $P$ and $Q$ are odd (for instance, $(1, 1)$), any split of an odd number produces one even and one odd pile. The next player can then pick the even pile and split it into $(1, \text{odd})$, forcing the first player back into having two odd piles until they are left with $(1, 1)$ and lose.
   - If **at least one** pile is even (i.e., $P \pmod 2 == 0$ or $Q \pmod 2 == 0$), Ashish can immediately choose an even pile and split it into $(1, \text{even} - 1)$—which gives Jeel two odd piles—and mirror Jeel's moves until Jeel is forced into $(1, 1)$.
3. **Validate and Print:** If `P % 2 == 0 || Q % 2 == 0`, print `"Ashish"`; otherwise, print `"Jeel"`.

### Time and Space Complexity
- **Time Complexity:** $O(1)$ per test case, or $O(T)$ overall for $T$ test cases.
- **Auxiliary Space Complexity:** $O(1)$ for storing input and result variables.

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
            long p = sc.nextLong();
            long q = sc.nextLong();
            
            if (p % 2 == 0 || q % 2 == 0) {
                System.out.println("Ashish");
            } else {
                System.out.println("Jeel");
            }
        }
        sc.close();
    }
}
```


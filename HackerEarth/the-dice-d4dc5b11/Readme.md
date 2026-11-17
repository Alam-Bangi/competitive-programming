# The Dice 🎲

## Problem Description
There are $x$ number of girls who roll a standard 6-sided dice in turns one after another. Whenever a girl rolls a `6`, she gets to roll the dice again until she gets a number other than `6`. Given a string $s$ ($1 \le |s| \le 10^5$) representing the sequence of numbers rolled on the dice, your task is to determine the **total number of girls** who played. If the sequence is invalid (for example, if the sequence ends with a `6`, meaning the last girl never finished her turn, or contains invalid dice digits), print `-1`.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Basics of Implementation
- **Difficulty:** Easy
- **Problem Link:** [The Dice](https://www.hackerearth.com/community/problem/algorithm/the-dice-d4dc5b11)

---

## Method / Approach
Every girl's turn continues as long as she rolls a `6` and ends the exact moment she rolls a number from `1` to `5`. Therefore, each valid turn corresponds to one non-`6` roll in the string:

1. **Read the Input:** Read the string $s$ representing the sequence of dice rolls.
2. **Validate the Sequence:** Check the last character of the string (and verify all characters are between `'1'` and `'6'`). If the string ends with `'6'`, the final turn is incomplete, making the sequence invalid (`-1`).
3. **Count the Turns (Girls):** Iterate through each character of the string. Every time a digit is between `'1'` and `'5'`, increment the `girls` counter by `1`.
4. **Print the Result:** Output the total count of `girls` (or `-1` if invalid).

### Time and Space Complexity
- **Time Complexity:** $O(N)$, where $N = |s|$ is the length of the input string, as we scan the string once.
- **Auxiliary Space Complexity:** $O(1)$ excluding the space used to store the input string.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if (s.charAt(s.length() - 1) == '6') {
            System.out.println(-1);
            sc.close();
            return;
        }

        int girls = 0;
        for (int i = 0; i < s.length(); i++) {
            char roll = s.charAt(i);

            if (roll < '1' || roll > '6') {
                System.out.println(-1);
                sc.close();
                return;
            }
            if (roll != '6') {
                girls++;
            }
        }
        System.out.println(girls);
        sc.close();
    }
}
```


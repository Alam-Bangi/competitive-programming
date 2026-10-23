# Bracket Sequence 🔗

## Problem Description

A bracket sequence is a string that contains only the characters `(` and `)`.

A correct bracket sequence is one that can be transformed into a correct arithmetic expression by inserting the characters `1` and `+` between the original characters.

For example:
- `()()` is a correct bracket sequence.
- `(())` is a correct bracket sequence.
- `(` and `)(` are incorrect bracket sequences.

You are given a bracket sequence `s`, which is not necessarily correct. Your task is to determine the number of cyclic shifts of `s` that result in a correct bracket sequence.

### Important Notes

- **Platform:** HackerEarth
- **Track:** Algorithms / Data Structures / Arrays / 1-D Array
- **Difficulty:** Easy / Practice
- **Problem Link:** [Bracket Sequence](https://www.hackerearth.com/community/problem/algorithm/bracket-sequence-1-40eab940)

---

## Format

- **Input:** A single line containing a bracket sequence `s`, consisting only of `(` and `)`.
- **Output:** Print a single integer representing the number of cyclic shifts that form a correct bracket sequence.

---

## Method / Approach

The problem can be solved in **O(n) time complexity** using prefix balances.

1. **Initialize Variables:** Set `balance = 0`, `minBalance = 0`, and `totalCount = 0`. Also, initialize counters for opening and closing brackets.
2. **Calculate Prefix Balance:** Traverse the string. Increase the balance by `1` for `(` and decrease it by `1` for `)`.
3. **Track Minimum Balance:** Whenever the balance becomes smaller than `minBalance`, update the minimum and reset `totalCount` to `0`.
4. **Count Minimum Occurrences:** Whenever the current balance equals `minBalance`, increment `totalCount`.
5. **Check Total Balance:** If the numbers of opening and closing brackets are equal, print `totalCount`. Otherwise, print `0`.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int counta = 0, countb = 0;
        int balance = 0, minBalance = 0, totalCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                counta++;
                balance++;
            } else {
                countb++;
                balance--;
            }

            if (balance < minBalance) {
                minBalance = balance;
                totalCount = 0;
            }

            if (balance == minBalance) {
                totalCount++;
            }
        }

        if (counta == countb) {
            System.out.println(totalCount);
        } else {
            System.out.println(0);
        }

        sc.close();
    }
}
```

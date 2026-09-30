# Excursion

## 📌 Problem Description
A school is organizing an excursion trip for its students. There are N boys and M girls participating. They need to book hotel rooms, where each room has a maximum capacity of K seats. However, boys and girls cannot share the same room. The task is to calculate the **minimum total number of rooms** required to accommodate all students.

* **Platform:** HackerEarth
* **Track:** Basic Programming / Implementation / Basics of Implementation
* **Difficulty:** Easy
* **Problem Link:** [Excursion](https://www.hackerearth.com/community/problem/algorithm/excursion-2d080f3a)

---

## 💡 Method / Approach
An optimal **Math** approach yields a **O(1) time complexity** per test case:
1. **Segregation:** Since boys and girls cannot share rooms, they must be processed completely independently.
2. **Ceiling Division:** Calculate the required rooms using integer ceiling division: `ceil(Total Students / Capacity)`. 
   * For N boys, the rooms needed are \(\lceil N / K \rceil\), which translates to `(n % k == 0) ? (n / k) : (n / k + 1)` in integer math.
   * Repeat the exact same step for the M girls.
3. **Aggregation:** Add both room counts together to get the final answer.

---

## 💻 Code Structure (Java 8)

```java
import java.util.*;

class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int b = sc.nextInt();
            int g = sc.nextInt();
            int k = sc.nextInt();

            int rooms = (b / k) + (g / k);

            if (b % k != 0) {
                rooms++;
            }
            if (g % k != 0) {
                rooms++;
            }
            System.out.println(rooms);
        }
    }
}

```

---

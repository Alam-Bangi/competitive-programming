# Simon cannot sleep 💬

## Problem Description
It is 12 o'clock at midnight (`00:00`) and Simon cannot sleep! He decides to stare at the clock on his wall until he falls asleep. He sees the clock's hands and wonders how many times they will overlap from `00:00` to a given time `hh:mm` (including `00:00` and `hh:mm`). The task is to **count the total number of times the hour and minute hands pass each other**.

### Important Notes:
* The clock has only hour and minute hands.
* The input time is in `hh:mm` format.
* The hands overlap approximately every 65.45 minutes (12/11 × 60 minutes).


* **Platform:** HackerEarth
* **Track:** Basic Programming / Implementation / Basics of Implementation
* **Difficulty:** Easy
* **Problem Link:** [Simon cannot sleep](https://hackerearth.com)

---

## Method / Approach
A simple **Math / Implementation** approach yields an optimal O(1) time complexity:
1. **Time Conversion:** Convert the given input time `hh:mm` into total elapsed minutes from midnight: `totalMin = (h * 60) + m`.
2. **Overlap Interval Calculation:** The minute and hour hands coincide once every \(\frac{720}{11}\) minutes (approx. 65.45 minutes).
3. **Count Formulation:** Divide the total minutes by the overlap interval duration, use `Math.floor()`, and add `1` to account for the initial overlap at `00:00`.

---

## Solution (Java 8)
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] parts = sc.next().split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int total = h * 60 + m;

        int[] limits = {66, 131, 197, 262, 328, 393, 458, 524, 589, 655, 720};

        int ans = 1;

        for (int limit : limits) {
            if (total >= limit)
                ans++;
        }

        System.out.println(ans);
    }
}
```


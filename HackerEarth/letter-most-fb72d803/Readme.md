# Letter Most 🔤

## Problem Description
Lonely Y loves his string of lowercase letters. Y is about to escape, so he should choose just one lowercase letter and carry all letters in the string which are equal to it with himself. The task is to find the **maximum number of letters** Y can carry with himself.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Algorithms / String Algorithm / String Searching / Practice Problems
* **Difficulty:** Easy
* **Problem Link:** [Letter most](https://www.hackerearth.com/community/problem/algorithm/letter-most-fb72d803)

### Format:
* **Input:** The first line contains an integer \(n\), representing the length of the string. The second line contains the string consisting only of lowercase English letters.
* **Output:** Print a single integer representing the maximum number of identical letters Y can carry.

---

## Method / Approach
The problem can be optimally solved in **\(O(n)\) time complexity** by tracking character frequencies:

1. **Initialize Frequency Array:** Create an integer array of size 26 to store the counts of each lowercase letter (`'a'` through `'z'`).
2. **Count Occurrences:** Loop through each character of the string and increment its respective index (`character - 'a'`) inside the frequency array.
3. **Track Maximum:** Maintain a running maximum variable that updates whenever a character's frequency exceeds the current highest count.
4. **Final Output:** Print the highest frequency value found after traversing the full string.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        HashMap<Character, Integer> freq = new HashMap<>();
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int count = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, count);

            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);
        sc.close();
    }
}
```
---

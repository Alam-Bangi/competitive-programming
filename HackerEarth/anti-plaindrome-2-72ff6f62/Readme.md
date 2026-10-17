# Anti-palindrome strings 🪙

## Problem Description
You are given a string `S` containing only lowercase English alphabets. You can swap two adjacent characters any number of times (including 0). A string is called **anti-palindrome** if it is not a palindrome. 

If it is possible to make the string an anti-palindrome, find the **lexicographically smallest** anti-palindrome. Otherwise, print **-1**.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Basic Programming / Implementation / Basics of Implementation
* **Difficulty:** Easy
* **Problem Link:** [Anti-palindrome strings](https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/anti-plaindrome-2-72ff6f62)

---

## Method / Approach
The problem asks for the lexicographically smallest arrangement, which heavily hints towards a **Sorting & Greedy** strategy:

1. **Lexicographical Order:** To ensure the resulting string is the smallest possible, the best starting strategy is to **sort the string** in ascending alphabetical order. 
2. **Palindrome Evaluation:** After sorting, check if the sorted string is a palindrome. A sorted string can only be a palindrome if all its characters are identical (e.g., `"aaaa"`).
3. **Optimisation:** 
   * If the sorted string is **not a palindrome**, it is automatically our answer because sorting guarantees it is the lexicographically smallest possible variation.
   * If the sorted string **is a palindrome** (which happens only if all characters are the same), it is completely impossible to arrange it into a non-palindrome. Hence, return `-1`.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;
import java.util.Arrays;

public class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            String s = sc.next();
            
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            
            boolean isPalindrome = true;
            int left = 0;
            int right = chars.length - 1;
            
            while (left < right) {
                if (chars[left] != chars[right]) {
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }
            
            if (isPalindrome) {
                System.out.println("-1");
            } else {
                System.out.println(new String(chars));
            }
        }
        sc.close();
    }
}
```


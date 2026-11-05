# Case Conversion 🔠

## Problem Description

**You are given a string** consisting of uppercase and lowercase English letters. Your task is to convert the uppercase letters into lowercase letters and lowercase letters into uppercase letters.

In other words, you need to toggle the case of every character in the given string.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Strings
- **Difficulty:** Easy
- **Problem Link:** [Case Conversion](https://www.hackerearth.com/community/problem/algorithm/case-conversion-d19fbcfe)

---

## Method / Approach

The problem can be solved in **O(N) time** using Java's built-in character conversion methods.

1. **Read the Input:** Take the string as input from the user.
2. **Traverse the String:** Iterate through each character of the string.
3. **Convert the Case:**
   - If the character is uppercase, convert it into lowercase using `Character.toLowerCase()`.
   - If the character is lowercase, convert it into uppercase using `Character.toUpperCase()`.
4. **Print the Result:** Append the converted characters to a new string and print it.

### Time and Space Complexity
- **Time Complexity:** O(N), where N is the length of the string.
- **Auxiliary Space Complexity:** O(N) for storing the converted string.

---

## Solution

### Java (Java 8)

```java
import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String s = br.readLine();

            String out_ = caseConversion(s);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static String caseConversion(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isUpperCase(ch)) {
                if (i != 0) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
```

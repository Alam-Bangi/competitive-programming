# Count in string

- **Platform:** HackerEarth
- **Difficulty:** Easy
- **Track:** Basic Programming / Implementation / Basics of Implementation
- **Problem Link:** [Count in string](https://www.hackerearth.com/community/problem/algorithm/count-in-string-5114694d)

## Problem Description

You are given a string $S$ containing lowercase English alphabets and a character $k$. Your task is to **count the total number of occurrences** of the character $k$ inside the string $S$.

## Approach

This problem can be directly solved with a simple linear scan (**Implementation Strategy**):
1. **Iterate Through the String:** Loop through each character of the string $S$ from index `0` to `S.length() - 1`.
2. **Match and Increment:** Compare each character with the target character $k$. If they match, increment a counter variable.
3. **Return Answer:** After checking the whole string, output the final count for the given test case.

## Solution (Java 8)

```java
import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String S = br.readLine();
            char k = br.readLine().trim().charAt(0);

            int out_ = solve(S, k);
            System.out.println(out_);

         }

         wr.close();
         br.close();
    }
    static int solve(String S, char k){
       // Write your code here
        int result = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == k) {
                result++;
            }
        }
        return result;

    }
}
```


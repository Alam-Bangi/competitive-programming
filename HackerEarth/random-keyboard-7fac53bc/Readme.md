# Random Keyboard 🎹

## Problem Description
A custom keyboard layout is provided with $N$ rows, where each row contains a unique set of characters. Given a target word $W$, the task is to determine the total number of **distinct rows** required to type the entire word.

### Important Notes:
* Each character in the target word is guaranteed to exist on the keyboard.
* The rows are provided as strings of characters.
* **Platform:** HackerEarth
* **Track:** Algorithms / String Searching
* **Difficulty:** Easy
* **Problem Link:** [Random Keyboard](https://hackerearth.com)

---

## Method / Approach
A **Hash Map & Set** approach yields an optimal $O(K + |W|)$ time complexity, where $K$ is the total number of characters across all keyboard rows:

1. **Keyboard Mapping:** Iterate through each row of the keyboard. Store each character in a hash map as the key, with its corresponding row index as the value.
2. **Row Tracking:** Iterate through each character of the target word $W$. Look up its row index in the hash map and insert it into a hash set. 
3. **Result:** The size of the set represents the exact number of distinct rows used to type the word.

---

## Solution (Java 8)

```java
import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] keyboard = new String[N];
         for(int i_keyboard = 0; i_keyboard < N; i_keyboard++)
         {
         	keyboard[i_keyboard] = br.readLine();
         }
         String word = br.readLine();

         int out_ = solve(N, keyboard, word);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int solve(int N, String[] keyboard, String word){
       // Write your code here
        int result = 0;
        for (int i = 0; i < N; i++) {
            Set<Character> keys = new HashSet<>();
            for (char ch : keyboard[i].toCharArray()) {
                keys.add(ch);
            }
            boolean valid = true;

            for (char ch : word.toCharArray()) {
                if (!keys.contains(ch)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result = 1;
                break;
            }
        }
        return result;
    }
}
```


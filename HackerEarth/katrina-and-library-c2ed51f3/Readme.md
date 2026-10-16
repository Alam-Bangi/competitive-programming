# Alice's Library 📚

## Problem Description
Alice is rearranging her library. She takes the innermost shelf and reverses the order of books. She breaks the walls of the shelf. In the end, there will be only books and no shelf walls. The task is to print the final order of the books.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Data Structures / Stacks / Basics of Stacks
* **Difficulty:** Easy
* **Problem Link:** [Alice's library](https://hackerearth.com/community/problem/algorithm/katrina-and-library-c2ed51f3)

### Format:
* **Opening and closing walls:** Shown by `/` and `\` respectively.
* **Books:** Represented by lowercase English alphabets.

---

## Method / Approach
The problem can be efficiently solved using a **Stack** approach to manage the nested structures:

1. **Iterate & Push:** Loop through each character of the string. If the character is an alphabet or an opening shelf wall `/`, push it directly onto the stack.
2. **Handle Closing Wall:** When you encounter a closing shelf wall `\`, it signifies the end of the innermost shelf. 
3. **Pop & Reverse:** Pop elements from the stack one by one until you reach the corresponding opening wall `/`. Accumulate these characters into a temporary string. Since a stack follows **Last-In, First-Out (LIFO)** behavior, popping them inherently reverses the order of books.
4. **Remove Wall & Restore:** Pop the opening wall `/` to break it. Then, push the reversed characters back onto the stack so they can be processed if nested inside an outer shelf.
5. **Final Output:** Once the iteration finishes, the stack will contain only the final book order in reverse sequence. Pop everything to form the final result string and print it.

---

## Solution

### Java (Java 8)
```java
import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder str = new StringBuilder(s);

        while (str.indexOf("/") != -1) {
            int start = str.lastIndexOf("/");
            int end = str.indexOf("\\", start);

            String rev = new StringBuilder(str.substring(start + 1, end))
                            .reverse().toString();

            str.replace(start, end + 1, rev);
        }

        System.out.println(str);
        sc.close();
    }
}
```


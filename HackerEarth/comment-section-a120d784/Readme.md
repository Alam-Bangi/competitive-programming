# Comment Section 💬

## Problem Description
A new video has been published on the HackerEarth social media handle, receiving $N$ comments. The admin wants to search the comment section for a specific keyword $S$ to find potential derogatory comments. 

The task is to **count the total number of comments that contain the keyword $S$**.

### Important Notes:
* The search is **case-insensitive** (e.g., "bad" matches "BAD").
* The words in the comments are separated by underscores (`_`).
* The final count can be `0`.

* **Platform:** HackerEarth
* **Track:** Algorithms / String Searching / Real World
* **Difficulty:** Easy
* **Problem Link:** [Comment Section](https://www.hackerearth.com/community/problem/algorithm/comment-section-a120d784)

---

## Method / Approach
A straightforward **String Matching** approach yields an optimal $O(\sum |comments|)$ time complexity:

1. **Case Normalization:** Convert both the keyword $S$ and each individual comment to lowercase (or uppercase) to handle the case-insensitivity condition.
2. **Tokenization vs substring matching:** The problem statement mentions *"The separator here is '_'."* However, looking at Example 2 (`"bad_bad_bad"` contains `"bad"`), standard substring checking or splitting by `_` works perfectly. Since we just need to verify if the keyword exists as a token or substring inside the comment, checking `.contains()` on the lowercased strings is robust and clean.
3. **Counter:** Increment a counter whenever a comment satisfies the match, then return the total.

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
         String S = br.readLine();
         String[] comments = new String[N];
         for (int i = 0; i < N; i++){
               comments[i] = br.readLine();
         }
         int out_ = solution(N, S, comments);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int solution(int N, String S, String[] comments){
       // Write your code here
        int result = 0;
        String lowerS = S.toLowerCase();

        for (String commentStr : comments) {
            if (commentStr != null) {
                String[] individualComments = commentStr.split(" ");
                
                for (String comment : individualComments) {
                    if (!comment.isEmpty() && comment.toLowerCase().contains(lowerS)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
```

---


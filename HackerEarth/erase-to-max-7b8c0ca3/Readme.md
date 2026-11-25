# Erase to Max 🗑️

## Problem Description

You are given an array $A$ of size $N$ ($1 \le N \le 10^5$), where each element satisfies $1 \le A[i] \le 10^6$. You must choose any value $x$ present in $A$ and remove **all occurrences** of $x$ from the array. You are required to perform this operation **exactly once**.

Given $T$ test cases ($1 \le T \le 10$), compute the **maximum possible sum** of the remaining elements in $A$ after removing all occurrences of your chosen element $x$.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basic Programming / Basics of Implementation
- **Difficulty:** Easy
- **Problem Link:** [Erase to max](https://www.hackerearth.com/community/problem/algorithm/erase-to-max-7b8c0ca3)

---

## Method / Approach

Let `totalSum` be the sum of all elements in the original array $A$. If we choose to remove all occurrences of a distinct element $x$ whose frequency in $A$ is `freq[x]`, the total sum removed from the array is $x \times \text{freq}[x]$. Thus, the remaining sum becomes:

$$\text{Remaining Sum} = \text{totalSum} - (x \times \text{freq}[x])$$

To **maximize** the remaining sum, we need to **minimize** the total value removed $(x \times \text{freq}[x])$ among all elements $x$ that appear at least once in $A$:

1. **Read the Input & Track Frequencies:**
   - Read the number of test cases $T$.
   - For each test case, read $N$ and the $N$ integers of array $A$.
   - Use a frequency array of size $10^6 + 1$ (or a `HashMap`) to count how many times each element appears, while simultaneously accumulating `totalSum` in a `long` variable. *(Note: Since $N \le 10^5$ and $A[i] \le 10^6$, `totalSum` can reach $10^{11}$, which requires a 64-bit `long` integer to avoid overflow.)*
2. **Find the Minimum Removal Cost:**
   - Initialize `minRemoval = Long.MAX_VALUE`.
   - Iterate through all valid values $x$ from $1$ to $10^6$ (or over the keys in the map).
   - If `freq[x] > 0`, compute `removalCost = (long) x * freq[x]` and update `minRemoval = Math.min(minRemoval, removalCost)`.
3. **Compute and Print the Result:**
   - Subtract `minRemoval` from `totalSum` and print `totalSum - minRemoval`.

### Time and Space Complexity
- **Time Complexity:** $O(N + M)$ per test case, where $N \le 10^5$ is the array size and $M = 10^6$ is the maximum possible element value (or $O(N)$ using a hash map). Across $T \le 10$ test cases, this easily runs well within the 3-second time limit.
- **Auxiliary Space Complexity:** $O(M)$ (specifically $O(10^6)$) for the frequency array, or $O(N)$ using a hash map.

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
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_Arr = br.readLine().split(" ");
            int[] Arr = new int[N];
            for(int i_Arr=0; i_Arr<arr_Arr.length; i_Arr++)
            {
            	Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
            }

            long out_ = getResult(Arr);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static long getResult(int[] Arr){
        long totalSum = 0;
        Map<Integer, Long> freq = new HashMap<>();
        
        for (int num : Arr) {
            totalSum += num;
            freq.put(num, freq.getOrDefault(num, 0L) + 1L);
        }
        
        long maxSum = Long.MIN_VALUE;        
        for (Map.Entry<Integer, Long> entry : freq.entrySet()) {
            long val = entry.getKey();
            long count = entry.getValue();
            long remainingSum = totalSum - (val * count);
            
            if (remainingSum > maxSum) {
                maxSum = remainingSum;
            }
        }
        return maxSum;
    }
}
```

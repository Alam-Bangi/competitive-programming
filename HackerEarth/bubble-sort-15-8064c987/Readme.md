# Bubble Sort 🧼

## Problem Description
You are given an array \(A\) of size \(N\). You need to sort this array in non-decreasing order using the **Bubble Sort** algorithm. However, instead of printing the sorted array, your task is to **print the total number of swaps** required to sort the array.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Algorithms / Sorting / Bubble Sort
* **Difficulty:** Very Easy
* **Problem Link:** [Bubble Sort](https://www.hackerearth.com/community/problem/algorithm/bubble-sort-15-8064c987)

### Format:
* **Input Format:** 
  * The first line consists of a single integer \(N\) denoting the size of the array.
  * The next line contains \(N\) space-separated integers denoting the elements of the array.
* **Output Format:** Print the total number of swaps in a single line.
* **Constraints:** \(1 \le N \le 100\), \(1 \le A[i] \le 100\).

---

## Method / Approach
The problem asks specifically for the swap count using standard Bubble Sort:
1. **Nested Loops:** Use an outer loop running from \(N-1\) down to \(1\) to dictate the boundary of the unsorted segment. 
2. **Adjacent Comparison:** Use an inner loop to step through the unsorted array up to the current boundary, comparing adjacent elements `A[j]` and `A[j+1]`.
3. **Count Swaps:** If `A[j] > A[j+1]`, they are in the wrong order. Swap them and increment a counter variable (`count++`).
4. **Final Output:** Once the loops finish running, print the final counter value.

---

## Solution

### Java (Java 8)
```java
import java.util.*;

public class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int swapCount = 0;
        
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    // Increment swap count
                    swapCount++;
                }
            }
        }        
        System.out.println(swapCount);
        
        sc.close();
    }
}
```


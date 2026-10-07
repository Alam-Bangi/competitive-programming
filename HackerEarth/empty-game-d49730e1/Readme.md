# Empty Game 🎮

## Problem Description
You are given an array `A` of length `N`. In one move, you can select any integer `X` and perform one of the following operations:
* Choose **one index** `i` (1 ≤ i ≤ N) such that \(\vert{}A[i] - X\vert{} \le 1\) and remove \(A[i]\) from the array.
* Choose **two distinct indices** `i` and `j` (1 ≤ i, j ≤ N, i ≠ j) such that \(\vert{}A[i] - X\vert{} \le 1\) and \(\vert{}A[j] - X\vert{} \le 1\), and remove both \(A[i]\) and \(A[j]\) from the array.

The task is to find the **minimum number of moves required to make the array empty**.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Algorithms / Greedy Algorithms / Basics of Greedy Algorithms
* **Difficulty:** Easy
* **Problem Link:** [Empty Game](https://hackerearth.com)

---

## Method / Approach
A **Greedy / Sorting** strategy solves this optimally:
1. **Sort the Array:** Sort the elements of array `A` in non-decreasing order. This ensures that elements with similar values are placed adjacent to each other.
2. **Greedy Pairing:** Traverse through the sorted array. Since we can choose any integer X, a single move can remove any two numbers whose absolute difference is at most 2 (by picking X as their midpoint value). 
3. **Condition Check:** For any two adjacent active elements \(A[i]\) and \(A[i+1]\), check if \(A[i+1] - A[i] \le 2\). If they satisfy this property, eliminate both elements together in **1 move** and advance your pointer by 2.
4. **Single Elimination:** If they do not satisfy the property, \(A[i]\) must be eliminated by itself in **1 move**. Advance your pointer by 1.

This ensures a time complexity of \(O(N \log N)\) due to sorting, and O(1) auxiliary space complexity.

---

## Solution (Java 8)

```java
import java.util.Arrays;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        
        while (t > 0) {
            int n = sc.nextInt(); 
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }            
            Arrays.sort(a);
            
            int moves = 0;
            int i = 0;
            while (i < n) {
                if (i + 1 < n && a[i + 1] - a[i] <= 2) {
                    moves++; 
                    i += 2;  
                } else {
                    moves++; 
                    i += 1;  
                }
            }
            System.out.println(moves);
            t--;
        }
        sc.close();
    }
}
```


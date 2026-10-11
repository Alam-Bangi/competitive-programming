# Erasing an Array 🗑️

## Problem Description
You are given a binary array `A` of size `N` consisting of `0`s and `1`s. You can perform the following operation as many times as needed: Select a subarray starting from the first index that is **inversion-free** and delete it. The task is to determine the **minimum number of operations** required to delete the entire array.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Basic Programming / Implementation / Basics of Implementation
* **Difficulty:** Easy
* **Problem Link:** [Erasing an array](https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/erasing-the-array-7e9e0400/)

---

## Method / Approach
A **Greedy Adjacent Comparison** approach solves this problem efficiently in \(O(N)\) time complexity:

1. **Inversion-Free Rule:** A subarray starting from the first index is inversion-free if and only if it is sorted in non-decreasing order. 
2. **Identify Breakpoints:** As you traverse the array from left to right, you can greedily extend the deleted prefix as long as the elements do not decrease (\(A[i] \leq A[i+1]\)). 
3. **Count Operations:** The moment you encounter a strict drop where \(A[i] > A[i+1]\) (a `1` followed by a `0`), a new deletion operation becomes mandatory because including the `0` would create an inversion. Therefore, the total operations needed equals `1 + (number of times A[i] > A[i+1])`.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            int operations = 0;
            int i = 0;
            
            while (i < n) {
                operations++;
                
                while (i < n && arr[i] == 0) {
                    i++;
                }
                
                while (i < n && arr[i] == 1) {
                    i++;
                }
            }                
            System.out.println(operations);
        }
        sc.close();
    }
}
```


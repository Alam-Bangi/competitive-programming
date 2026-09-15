# Not Even Max Sum

- **Platform:** HackerEarth
- **Difficulty:** Easy
- **Track:** Algorithms / Greedy / Basics of Greedy Algorithms
- **Problem Link:** [Not Even Max Sum](https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/not-even-max-sum-a3ccf284/)

## Problem Description
You are given an array $A$ of $N$ positive integers. Your task is to find the **maximum possible sum** of a subset of elements such that the sum is **not even** (i.e., it must be **odd**).

If it is impossible to get an odd sum (e.g., if there are no odd numbers in the array), return `0`.

## Approach
This problem can be optimally solved using a **Greedy Strategy**:
1. **Calculate Total Sum:** Find the sum of all elements in the array and track the smallest odd number present.
2. **Check Parity:**
    - If the total sum is already **odd**, it is the maximum possible odd sum because all elements are positive integers.
    - If the total sum is **even**, we must remove an element to change its parity to odd. To maximize the remaining sum, we should remove the **smallest possible odd number** from the total sum.
3. **Edge Case:** If the array contains no odd numbers at all, it is impossible to form an odd sum, so return `0`.

## Solution (Java 8)

```java
import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solve(n, arr));
        }
        sc.close();
    }
    static long solve(int n, int[] arr) {
        long evenSum = 0;
        long oddSum = 0;
        int countOdd = 0;
        int smallestOdd = Integer.MAX_VALUE;

        for (int x : arr) {
            if (x % 2 == 0) {
                evenSum += x;
            } else {
                oddSum += x;
                countOdd++;
                smallestOdd = Math.min(smallestOdd, x);
            }
        }
        if (countOdd == 0) {
            return -1;
        }
        if (countOdd % 2 == 1) {
            return evenSum + oddSum;
        }
        return evenSum + oddSum - smallestOdd;
    }
}
```

## Complexity Analysis
- **Time Complexity:** $\mathcal{O}(N)$ per testcase because we iterate through the array exactly once to calculate the sum and find the minimum odd element.
- **Space Complexity:** $\mathcal{O}(N)$ to store the array elements. Can be optimized to $\mathcal{O}(1)$ auxiliary space if input is processed on the fly.

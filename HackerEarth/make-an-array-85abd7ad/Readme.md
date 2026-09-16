
# Make an array

- **Platform:** HackerEarth
- **Difficulty:** Easy
- **Track:** Algorithms / Searching / Linear Search
- **Problem Link:** [Make an array](https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/make-an-array-85abd7ad/)

## Problem Description
You are given an array A of length N. You take an array B of length N such that \(B[i] = 0\) for each 1 ≤ i ≤ N. 

You can apply the following operation on B any number of times:
- Choose (N - 1) distinct indices and add 1 to each of those indices.

**Task:** Find the number of operations required to convert array B into array A by applying the given operation. Print `-1` if it is impossible to do so.

## Approach
1. Each operation increments N - 1 elements by 1, which means the total sum of array elements increases by N - 1 in each operation.
2. Therefore, the sum of all elements in A must be divisible by N - 1. If `sum(A) % (N - 1) != 0`, it is impossible, so return `-1`.
3. The number of operations `k` would be `sum(A) // (N - 1)`.
4. In each operation, we can leave at most one element un-incremented. Thus, no element in A can be strictly greater than the total number of operations `k`.
5. If any element `A[i] > k`, it is impossible to form that value, so return `-1`. Otherwise, return `k`.

## Solution (Java 8)

```java
import java.io.*;
import java.util.*;

public class MakeAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            int out_ = solve(N, A);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    static int solve(int N, int[] A){
        if (N == 1) {
            return (A[0] == 0) ? 0 : -1;
        }

        long totalSum = 0;
        int maxElement = 0;

        for (int i = 0; i < N; i++) {
            totalSum += A[i];
            if (A[i] > maxElement) {
                maxElement = A[i];
            }
        }

        if (totalSum % (N - 1) != 0) {
            return -1;
        }

        long k = totalSum / (N - 1);

        if (k >= maxElement) {
            return (int) k;
        } else {
            return -1;
        }
    }
}


```


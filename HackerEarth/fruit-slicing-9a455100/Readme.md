# Fruit Slicing 🍉

## Problem Description

The problem asks you to calculate the **total number of slices** required based on the given number of fruits and the number of slices required for each fruit.

### Important Notes:

* Read the number of fruits and the number of slices required for each fruit.
* Calculate the total number of slices using multiplication.
* The final answer is the product of the given values.

* **Platform:** HackerEarth
* **Track:** Algorithms / Mathematics
* **Difficulty:** Easy
* **Problem Link:** [Fruit Slicing](https://www.hackerearth.com/community/problem/algorithm/fruit-slicing-9a455100)

---

## Method / Approach

A straightforward **Mathematical / Arithmetic** approach yields an optimal $O(1)$ time complexity:

1. **Input:** Read the number of fruits `N` and the number of slices required for each fruit `K`.
2. **Calculation:** Multiply the number of fruits by the number of slices required for each fruit.
3. **Result:** Store the calculated value and print it.

---

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
       // Write your code here
        int result = 0;

        HashSet<Integer> uniqueWeights = new HashSet<>();
        
        for (int weight : A) {
            uniqueWeights.add(weight);
        }
        result = uniqueWeights.size();

        return result;
    }
}
```

---

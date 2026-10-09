# Chocolate Stack 🍫

## Problem Description
You are given an array `C` of size `N` which describes operations performed on a chocolate stack over `N` minutes:
* If `C[i] > 0`, it means a box containing `C[i]` chocolates is received and placed on the **top of the stack**.
* If `C[i] = 0`, it means the shop **sells the top box** from the stack. 

The task is to determine and return the number of chocolates in each sold box in the order they are purchased.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Data Structures / Stacks / Basics of Stacks
* **Difficulty:** Easy
* **Problem Link:** [Chocolate stack](https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/chocolate-stack-746c1b56/)

---

## Method / Approach
A **Stack Data Structure** perfectly models this Last-In, First-Out (LIFO) behavior:
1. **Push Mechanism:** As we iterate through the array `C`, whenever we encounter a value greater than `0`, we push it onto the stack.
2. **Pop & Record Mechanism:** When we encounter a `0`, we pop the top element from the stack (which represents the most recently added chocolate box) and add its value to our output list.
3. **Optimized I/O:** Since N can be up to 10⁵, using standard fast I/O utilities like `BufferedReader` and `StringTokenizer` avoids potential Time Limit Exceeded (TLE) issues.

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
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_C = br.readLine().split(" ");
         int[] C = new int[N];
         for(int i_C = 0; i_C < arr_C.length; i_C++)
         {
            C[i_C] = Integer.parseInt(arr_C[i_C]);
         }

         int[] out_ = solution(N, C);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
            System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] solution(int N, int[] C){

            int[] stack = new int[N];
            int top = -1;

            int[] result = new int[N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (C[i] == 0) {
                    result[count] = stack[top];
                    count++;
                    top--;
                } else {
                    top++;
                    stack[top] = C[i];
                }
            }
            return Arrays.copyOf(result, count);
    } 
}
```


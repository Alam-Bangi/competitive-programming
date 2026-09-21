# Too Chocolatey

## Problem Description
**Alex** and **Bob** are playing a game where each player consumes chocolates from an array A of size N, where \(A_i\) represents the quantity of chocolate at the i-th position. The person who consumes the **most total chocolates** is declared the winner of the game. 

However, there is a condition: **each player can consume a specific quantity of chocolate (sugar) only once**. If a player has already consumed a pile with a certain quantity, any remaining piles with that same quantity are skipped by that player during their turn. 

Assuming **Alex goes first** and both players play optimally/greedily to maximize their own chocolate intake, determine the winner of the game. If Alex consumes strictly more chocolate than Bob, **Alex wins**; otherwise, **Bob wins**.

* **Platform:** HackerEarth
* **Track:** Algorithms / Greedy / Basics of Greedy Algorithms
* **Difficulty:** Easy
* **Problem Link:** [Too Chocolatey](https://www.hackerearth.com/community/problem/algorithm/too-chocolatey-232e97e0)

------------------------------

## Method / Approach
Given that both players want to maximize their total chocolate and can choose any valid available pile, a **Greedy Approach using Two Pointers** works perfectly:

1. **Sort the Array:** Sort the chocolate piles array A in **descending order** so that the largest values are processed first.
2. **Track Pointers and Sets:** Maintain independent tracking pointers (`alexPtr` and `bobPtr`) that traverse the sorted array, alongside boolean arrays or sets to record the chocolate quantities each player has already eaten.
3. **Simulate Turns:** 
   * In Alex's turn, advance `alexPtr` past any piles that have already been taken by Bob, or contain a quantity Alex has already eaten. If a valid pile is found, Alex consumes it, marks it as taken, and records the quantity.
   * In Bob's turn, do the exact same using `bobPtr` and Bob's consumed history.
4. **Determine the Outcome:** Sum the totals consumed by each player. Since each pointer moves from 0 to N exactly once, the simulation runs efficiently in O(N) time after the initial \(O(N \log N)\) sorting step. If `alexTotal > bobTotal`, print `"Alex"`; otherwise, print `"Bob"`.

------------------------------

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
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i_arr = 0; i_arr < arr_arr.length; i_arr++)
            {
            	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }

            String out_ = solve(n, arr);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static String solve(int n, int[] A){
       // Write your code here
        String result = "";

        Arrays.sort(A);
        
        long alexScore = 0;
        long bobScore = 0;
        int turn = 0; 
        
        int i = N - 1;
        while (i >= 0) {
            int currentVal = A[i];
            int count = 0;
            
            while (i >= 0 && A[i] == currentVal) {
                count++;
                i--;
            }
            
            if (count == 1) {
                if (turn == 0) {
                    alexScore += currentVal;
                } else {
                    bobScore += currentVal;
                }
                turn = 1 - turn;
            } else {
                alexScore += currentVal;
                bobScore += currentVal;
            }
        }
        
        if (alexScore > bobScore) {
            result = "Alex";
        } else {
            result = "Bob";
        }
    }
    return result;
}
```


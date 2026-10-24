# Fun Game <Capillary> 🎮

## Problem Description
A and B are playing a game where both are initially provided with an identical copy of a list containing \(n\) numbers. Each player follows a different strategy to pick elements from their respective lists:
* **Player A** picks elements from the **start** of the list.
* **Player B** picks elements from the **end** of the list.

The task is to simulate the game and generate the result comparison list based on the following evaluation rules at each step:
1. If the number picked by A is **greater than** the number picked by B, output `1` and B removes their picked element.
2. If the number picked by A is **smaller than** the number picked by B, output `2` and A removes their picked element.
3. If the numbers are **equal**, output `0` and both players remove their respective elements.

The game terminates as soon as either player's list becomes completely empty.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Data Structures / Stacks / Basics of Stacks / Practice Problems
* **Difficulty:** Easy
* **Problem Link:** [Fun Game <Capillary>](https://www.hackerearth.com/community/problem/algorithm/fun-game-91510e9f)

### Format:
* **Input:** The first line contains an integer \(n\), representing the size of the initial list. The second line contains \(n\) space-separated integers representing the elements of the list.
* **Output:** Print space-separated integers representing the outcome generated at each step of the comparison game.

---

## Method / Approach
The problem can be optimally simulated in **\(O(n)\) time complexity** using a two-pointer technique or an array:
1. **Initialize Two Pointers:** Maintain a pointer `i` starting at index `0` (representing Player A's position) and a pointer `j` starting at index `n - 1` (representing Player B's position).
2. **Compare and Shift:** While `i < n` and `j >= 0`, compare `arr[i]` and `arr[j]`:
   * If `arr[i] > arr[j]`: Print `1` and decrement `j` (B removes the element).
   * If `arr[i] < arr[j]`: Print `2` and increment `i` (A removes the element).
   * If `arr[i] == arr[j]`: Print `0`, increment `i`, and decrement `j` (both remove elements).
3. **Termination:** The loop automatically halts when either pointer runs out of bounds, signifying an empty list copy.

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
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_arr = br.readLine().split(" ");
         int[] arr = new int[n];
         for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
         {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
         }

         int[] out_ = funGame(arr);
         System.out.print(out_[0]);
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
            System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] funGame(int[] arr){
        int n = arr.length;
        int i = 0;     
        int j = n - 1; 
        
        List<Integer> resultList = new ArrayList<>();
        
        while (i < n && j >= 0) {
            if (arr[i] > arr[j]) {
                resultList.add(1);
                j--; 
            } else if (arr[i] < arr[j]) {
                resultList.add(2);
                i++; 
            } else {
                resultList.add(0);
                i++; 
                j--;
            }
        }
        
        int[] out = new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) {
            out[k] = resultList.get(k);
        }
        return out;
    }
}

```


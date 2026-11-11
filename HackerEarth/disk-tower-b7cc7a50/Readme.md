# Disk tower 🏗️

## Problem Description

**You are given `N` disks** of sizes from `1` to `N`. On each day, you are given one disk of a distinct size. Your task is to construct a tower such that larger disks are placed at the bottom and smaller disks are placed at the top. If the largest required disk for the current top of the tower has not arrived yet, you must wait and print an empty line for that day.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Basics of Queues & Data Structures
- **Difficulty:** Easy
- **Problem Link:** [Disk tower](https://www.hackerearth.com/community/problem/algorithm/disk-tower-b7cc7a50)

---

## Method / Approach

The problem can be solved in **O(N) time** using a boolean array to keep track of available disks, while maintaining the current expected maximum disk size (`expectedSize`) that needs to be placed on top of the tower.

1. **Read the Input:** Read `N` (the total number of disks) followed by the sequence of disk sizes given over `N` days.
2. **Track Available Disks:** Use a boolean array (`received`) of size `N + 1` to mark each disk as arrived.
3. **Process Each Day:**
   - When a disk arrives, mark it as received in the array.
   - Check if the current largest expected disk (`expectedSize`) is already available.
   - If it is, append all consecutive available disks in descending order and decrement `expectedSize`. Otherwise, print an empty line.

### Time and Space Complexity
- **Time Complexity:** O(N), where `N` is the number of disks, since each disk is processed at most once.
- **Auxiliary Space Complexity:** O(N) for storing the boolean tracker array of size `N + 1`.

---

## Solution

### Java (Java 8)

```java
import java.io.*;
import java.util.*;


class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        ArrayList<Integer>[] out_ = Solve(arr);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

            for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
                System.out.print(out_[i_out_].get(j_out_) + " ");
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    static ArrayList<Integer>[] Solve(int[] arr) {
        int n = arr.length;
        ArrayList<Integer>[] result = new ArrayList[n];
        boolean[] available = new boolean[n + 1];
        int expected = n;

        for (int i = 0; i < n; i++) {
            result[i] = new ArrayList<>();
            available[arr[i]] = true;

            while (expected > 0 && available[expected]) {
                result[i].add(expected);
                expected--;
            }
        }
        return result;
    }
}
```


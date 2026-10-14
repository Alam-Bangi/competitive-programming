# Maximum Borders 🧱

## Problem Description
You are given a table with **\(N\)** rows and **\(M\)** columns. Each cell is colored white (`.`) or black (`#`). Considering the shapes created by connected black cells, your task is to find the **maximum border** among these shapes. 

The border of a shape is defined as the **maximum number of consecutive black cells** in any single row or column without any white cell in between.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Basic Programming / Input/Output / Basics of Input/Output
* **Difficulty:** Easy
* **Problem Link:** [Maximum borders](https://www.hackerearth.com/community/problem/algorithm/maximum-border-9767e14c)

---

## Method / Approach
The problem can be solved efficiently using a **Grid Traversal & Linear Scanning** approach:

1. **Row-wise Scan:** For each row, iterate through the columns to count the length of continuous segments of `#`. Keep track of the maximum continuous segment found across all rows.
2. **Column-wise Scan:** For each column, iterate through the rows to count the length of continuous segments of `#`. Keep track of the maximum continuous segment found across all columns.
3. **Result:** The overall maximum value obtained from both row-wise and column-wise scans represents the longest border.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;

public class MaximumBorders {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        char[][] shapes;
        for (int n = 0; n < testCases; n++) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();
            shapes = new char[rows][columns];
            String s = "";
            for (int i = 0; i < rows; i++) {
                    s = sc.next();
                for (int j = 0; j < columns; j++) {
                    shapes[i][j] = s.charAt(j);
                }
            }

            int c = 0;
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (c < count) {
                    c = count;
                }
                count = 0;
                for (int j = 0; j < columns; j++) {
                    if (shapes[i][j] == ('#')) {
                        count++;
                        if (shapes[i][j + 1] == ('.')) {
                            break;
                        }
                    }   
                }
            }
            if (c > count) {
                System.out.println(c);
            } else {
                System.out.println(count);
            }
        }
    }
}
```


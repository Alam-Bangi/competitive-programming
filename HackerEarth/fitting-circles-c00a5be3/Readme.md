# Fitting circles ⭕

## Problem Description
**You are given a rectangle of length \(a\) and width \(b\)**. You are required to determine a circle that contains the maximum circumference that fits inside the rectangle. This type of circle is called a **big circle**. Your task is to determine the **maximum number of big circles** that can fit inside the rectangle.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Basic Programming / Implementation / Basics of Implementation / Practice Problems
* **Difficulty:** Easy
* **Problem Link:** [Fitting circles](https://www.hackerearth.com/community/problem/algorithm/fitting-circles-c00a5be3)

### Format:
* **Input:** The first line contains an integer \(t\) denoting the number of test cases. Each of the next \(t\) lines contains two space-separated integers representing the length \(a\) and width \(b\) of the rectangle.
* **Output:** For each testcase, print a single integer representing the maximum number of big circles that can fit inside the provided rectangle.

---

## Method / Approach
The problem can be solved efficiently using basic geometric observation in \(O(1)\) time per test case:

1. **Find Diameter of the Big Circle:** To fit a circle inside a rectangle with dimensions \(a\) and \(b\) while maximizing its circumference, the diameter of the circle must equal the smaller dimension of the rectangle, which is `min(a, b)`.
2. **Maximize Circle Count:** The circle can be duplicated and placed side-by-side along the larger dimension of the rectangle. The maximum number of such circles that can fit is the larger dimension divided by the smaller dimension, calculated using integer division: `max(a, b) / min(a, b)`.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            long L = sc.nextLong();
            long W = sc.nextLong();
            
            long diameter = Math.min(L, W);
            long availableLength = Math.max(L, W);
            
            long maxCircles = availableLength / diameter;
            
            System.out.println(maxCircles);
        }
        sc.close();
    }
}

```


# Build a Graph 🔠

## Problem Description
You are given an integer N. Determine if there is an unconnected graph with N vertices that contains at least two connected components and contains a number of edges that is equal to the number of vertices.

### Important Notes:
- **Platform:** HackerEarth
- **Track:** Algorithms / Graphs / Graph Representation
- **Difficulty:** Easy
- **Problem Link:** [Build a graph](https://www.hackerearth.com/practice/algorithms/graphs/graph-representation/practice-problems/algorithm/build-a-graph-5f5c6b4a/)

---

## Method / Approach
The problem boils down to a simple mathematical constraint checking operation rather than building an actual adjacency list or matrix.

1. **Understand the Property:** A graph where the number of edges equals the number of vertices (V = E) must contain cycles.
2. **Component Constraint:** The problem states the graph must be unconnected with at least two connected components.
3. **Threshold Logic:** The smallest self-contained simple graph component where V = E is a cycle of 3 vertices (a triangle, 3 vertices, 3 edges). To have at least two components that aggregate to V = E, the minimum number of vertices required to successfully fulfill these conditions is **N ≥ 5**.
4. **Conditional Output:** 
   - If N ≥ 5, print `Yes`.
   - If N < 5, print `No`.

### Time and Space Complexity
- **Time Complexity:** \(\mathcal{O}(1)\) as it only requires a single conditional check per test case.
- **Auxiliary Space Complexity:** \(\mathcal{O}(1)\) as no dynamic structures are used.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n >= 12) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        sc.close();
    }
}
```


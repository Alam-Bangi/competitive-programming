# Determining numbers 🔢

## Problem Description
**You are given an array of integers**. The special property of the array is that exactly two different elements occur once while all other elements occur twice. Your task is to determine those two elements and print them in ascending order.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Basic Programming / Bit Manipulation / Basics of Bit Manipulation / Practice Problems
* **Difficulty:** Easy
* **Problem Link:** [Determining numbers](https://www.hackerearth.com/community/problem/algorithm/find-the-numbers-75f24949)

### Format:
* **Input:** The first line contains an integer \(N\) denoting the number of elements in the array. The next line contains \(N\) space-separated integers representing the elements of the array.
* **Output:** Print the two unique elements separated by a space in ascending order.

---

## Method / Approach
The problem can be solved optimally in \(O(N)\) time and \(O(1)\) auxiliary space using **Bit Manipulation (XOR)**:

1. **XOR All Elements:** XORing a number with itself results in 0 (\(X \oplus X = 0\)). If we XOR all elements of the array together, the duplicate pairs will cancel each other out. The final result will be equal to \(X \oplus Y\), where \(X\) and \(Y\) are the two unique numbers.
2. **Find the Differentiating Bit:** Since \(X \neq Y\), their XOR sum (\(X \oplus Y\)) must have at least one set bit (a bit with a value of 1). We can isolate the rightmost set bit using the expression `xorSum & -xorSum`.
3. **Partition and Uncover:** We divide all numbers in the array into two groups: those that have this specific bit set, and those that do not. 
   * \(X\) and \(Y\) will fall into different groups because they differ at this bit position.
   * All duplicate pairs will fall into the same group and cancel each other out again when XORed within their respective groups.
   * XORing elements in the first group yields \(X\), and the second group yields \(Y\).

---

## Solution

### Java (Java 8)
```java
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}
```


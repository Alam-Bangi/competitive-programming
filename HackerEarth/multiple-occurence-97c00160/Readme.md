# Multiple Occurrences 🔢

## Problem Description
You are given an array `A` of size `N`. For every unique element that appears **two or more times** in the array, find the absolute difference between the index of its **first occurrence** and its **last occurrence**. The task is to calculate and return the total sum of these absolute differences for all unique repeating elements.

### Important Notes:
* **Platform:** HackerEarth
* **Track:** Basic Programming / Implementation / Basics of Implementation
* **Difficulty:** Easy
* **Problem Link:** [Multiple occurrences](https://www.hackerearth.com/community/problem/algorithm/multiple-occurence-97c00160)

---

## Method / Approach
A **Hash Map Tracker** approach solves this efficiently in \(O(N)\) time complexity:

1. **Track First and Last:** Maintain a hash map to save the **first occurrence index** of each unique element.
2. **Update on the Fly:** Maintain a secondary hash map (or update a tracking lookup) to continuously store the **last seen index** of each element as you traverse.
3. **Calculate Total Sum:** Iterate through the keys of your tracking map. For elements that appeared multiple times, compute `last_index - first_index` and add it to your global total.

---

## Solution

### Java (Java 8)
```java
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
            HashMap<Integer, Integer> lastOccurrence = new HashMap<>();
            
            for (int i = 1; i <= n; i++) {
                int val = sc.nextInt();
                
                if (!firstOccurrence.containsKey(val)) {
                    firstOccurrence.put(val, i);
                }
                lastOccurrence.put(val, i);
            }
            
            long totalSum = 0;
            
            for (int val : firstOccurrence.keySet()) {
                int first = firstOccurrence.get(val);
                int last = lastOccurrence.get(val);
                totalSum += (last - first); 
            }
            System.out.println(totalSum);
        }
    }
}
```



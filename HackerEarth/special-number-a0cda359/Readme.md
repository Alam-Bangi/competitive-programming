# A Special Number

## Problem DescriptionA number $n$ is said to be a **special number** if the sum of its digits is **divisible by 4**.

Given an integer $a$, your task is to find the smallest number $n$ such that:

   1. $n$ is a special number.
   2. $n \ge a$.


* Platform: HackerEarth
* Track: Basic Programming / Implementation / Basics of Implementation
* Difficulty: Easy
* Problem Link: [A Special Number](https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/special-number-9-a0cda359/)

------------------------------
## Method / Approach
Given the upper bound constraints on $a$ ($1 \le a \le 10^3$), we can employ a direct Simulation / Brute Force Approach:

   1. Start checking sequentially from the given integer $a$.
   2. For each number, compute the sum of its digits by extracting the last digit (num % 10) and shifting right (num / 10).
   3. Check if the computed sum is perfectly divisible by 4 (sum % 4 == 0).
   4. If it is divisible, that number is our minimum possible answer; output it and move to the next testcase. Otherwise, increment the number by 1 and repeat.

(Note: Since every block of 4 consecutive numbers contains at least one number whose digit sum is divisible by 4, the inner loop runs a maximum of 4 times per test case, making this simulation incredibly fast).
------------------------------
## Solution (Java 8)
```java
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = n;
            
            while (true) {
                int temp = m;
                int sum = 0;
                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }
                
                if (sum % 4 == 0) {
                    System.out.println(m);
                    break;
                }
                m++;
            }
        }
        scanner.close();
    }
}
```

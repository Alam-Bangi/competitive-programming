import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solve(n, arr));
        }
        sc.close();
    }
    static long solve(int n, int[] arr) {
        long evenSum = 0;
        long oddSum = 0;
        int countOdd = 0;
        int smallestOdd = Integer.MAX_VALUE;

        for (int x : arr) {
            if (x % 2 == 0) {
                evenSum += x;
            } else {
                oddSum += x;
                countOdd++;
                smallestOdd = Math.min(smallestOdd, x);
            }
        }
        if (countOdd == 0) {
            return -1;
        }
        if (countOdd % 2 == 1) {
            return evenSum + oddSum;
        }
        return evenSum + oddSum - smallestOdd;
    }
}

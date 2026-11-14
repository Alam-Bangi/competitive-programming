import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ways = new int[n + 1];
        ways[1] = 1;

        for (int num = 2; num <= n; num++) {
            for (int digit = 2; digit <= 9; digit++) {
                if (num % digit == 0) {
                    ways[num] += ways[num / digit];
                }
            }
        }
        System.out.println(ways[n]);
        sc.close();
    }
}

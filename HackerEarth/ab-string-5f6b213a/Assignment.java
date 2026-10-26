import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int a = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A') {
                    a++;
                }
            }
            int leftB = 0;
            int min = a;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'B') {
                    leftB++;
                } else {
                    a--;
                }
                min = Math.min(min, leftB + a);
            }
            System.out.println(min);
        }
        sc.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += sc.nextLong();
            }

            if (sum / n <= k) {
                System.out.println(0);
            } else {
                long ans = sum / (k + 1) + 1;
                System.out.println(ans - n);
            }
        }
        sc.close();
    }
}

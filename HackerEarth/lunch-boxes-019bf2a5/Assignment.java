import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long lunchBoxes = sc.nextLong();
            int n = sc.nextInt();

            long[] orders = new long[n];

            for (int i = 0; i < n; i++) {
                orders[i] = sc.nextLong();
            }

            Arrays.sort(orders);

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (lunchBoxes >= orders[i]) {
                    lunchBoxes -= orders[i];
                    count++;
                } else {
                    break;
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}


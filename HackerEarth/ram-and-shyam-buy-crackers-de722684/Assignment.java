import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        for (int i = 0; i < n; i++) {
            int cost = sc.nextInt();
            Set<Integer> newSums = new HashSet<>();

            for (int sum : sums) {
                newSums.add(sum + cost);
            }
            sums.addAll(newSums);
        }

        int count = 0;
        for (int sum : sums) {
            if (sum > 0 && sum % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}

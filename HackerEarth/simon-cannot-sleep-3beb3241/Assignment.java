import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] parts = sc.next().split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int total = h * 60 + m;

        int[] limits = {66, 131, 197, 262, 328, 393, 458, 524, 589, 655, 720};

        int ans = 1;

        for (int limit : limits) {
            if (total >= limit)
                ans++;
        }

        System.out.println(ans);
    }
}


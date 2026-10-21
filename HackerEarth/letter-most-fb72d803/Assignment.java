import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        HashMap<Character, Integer> freq = new HashMap<>();
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int count = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, count);

            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);
        sc.close();
    }
}

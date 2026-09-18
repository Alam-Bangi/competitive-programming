import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int k = sc.nextInt();
        sc.close();

        Set<String> currentSet = new HashSet<>();
        currentSet.add(number);

        for (int step = 0; step < k; step++) {
            Set<String> nextSet = new HashSet<>();
            for (String s : currentSet) {
                for (int i = 0; i < s.length(); i++) {
                    String modified = s.substring(0, i) + s.substring(i + 1);
                    nextSet.add(modified);
                }
            }
            currentSet = nextSet;
        }

        int maxNum = 0;
        for (String s : currentSet) {
            int val = Integer.parseInt(s);
            if (val > maxNum) {
                maxNum = val;
            }
        }

        System.out.println(maxNum);
    }
}

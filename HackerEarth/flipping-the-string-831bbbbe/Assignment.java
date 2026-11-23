import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int pref = 0;
        int ans = 0;
        Map<Integer, Integer> firstPos = new HashMap<>();
        firstPos.put(0, -1);

        for (int i = 0; i < n; i++) {
            pref += (s.charAt(i) == '0') ? 1 : -1;

            if (pref > 0) {
                ans = Math.max(ans, i + 1);
            } else if (firstPos.containsKey(pref - 1)) {
                ans = Math.max(ans, i - firstPos.get(pref - 1));
            }
            firstPos.putIfAbsent(pref, i);
        }
        System.out.println(ans);
        sc.close();
    }
}

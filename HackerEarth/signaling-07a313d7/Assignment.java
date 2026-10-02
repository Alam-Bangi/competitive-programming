import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                String s = sc.next();
                
                System.out.println(solve(n, s));
            }
        }
    }
    public static int solve(int n, String s) {
        int maxContinuos = 0;
        int currentCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                currentCount++;
                if (currentCount > maxContinuos) {
                    maxContinuos = currentCount;
                }
            } else {
                currentCount = 0;
            }
        }        
        return maxContinuos;
    }
}


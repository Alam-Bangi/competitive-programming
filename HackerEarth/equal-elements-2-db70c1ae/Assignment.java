import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int evenCount = 0;
            int oddCount = 0;
            
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }            
            System.out.println(Math.min(evenCount, oddCount));
        }        
        sc.close();
    }
}


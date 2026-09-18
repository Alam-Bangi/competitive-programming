import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = n;
            
            while (true) {
                int temp = m;
                int sum = 0;
                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }
                
                if (sum % 4 == 0) {
                    System.out.println(m);
                    break;
                }
                m++;
            }
        }
        scanner.close();
    }
}

import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long target = n + 1;
            boolean isPrime = true;
            
            if (target < 2) {
                isPrime = false;
            } else if (target == 2) {
                isPrime = true;
            } else if (target % 2 == 0) {
                isPrime = false;
            } else {
                for (long i = 3; i * i <= target; i += 2) {
                    if (target % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            
            if (target > 2 && isPrime) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }        
        sc.close();
    }
}

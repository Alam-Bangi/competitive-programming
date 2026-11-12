import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        for (long a = n - 2; a >= 1; a--) {
            if (gcd(a, n) == 1) {
                System.out.println(a);
                break;
            }
        }
        sc.close();
    }
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

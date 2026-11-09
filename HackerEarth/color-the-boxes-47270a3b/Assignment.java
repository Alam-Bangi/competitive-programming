import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        long mod = 1000000007L;
        long ans = 1;

        for (int i = 1; i <= m; i++) {
            ans = (ans * i) % mod;
        }
        System.out.println(ans);

        sc.close();
    }
}

import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n >= 12) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        sc.close();
    }
}

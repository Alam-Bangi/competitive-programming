import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            long p = sc.nextLong();
            long q = sc.nextLong();
            
            if (p % 2 == 0 || q % 2 == 0) {
                System.out.println("Ashish");
            } else {
                System.out.println("Jeel");
            }
        }
        sc.close();
    }
}

import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            long actualSum = a + b;
            long bobSum = 0;
            long place = 1;
            
            while (a > 0 || b > 0) {
                long digitSum = ((a % 10) + (b % 10)) % 10;
                bobSum += digitSum * place;
                
                a /= 10;
                b /= 10;
                place *= 10;
            }   
            long error = actualSum - bobSum;
            System.out.println(error);
        }        
        sc.close();
    }
}

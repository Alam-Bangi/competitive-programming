import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            long L = sc.nextLong();
            long W = sc.nextLong();
            
            long diameter = Math.min(L, W);
            long availableLength = Math.max(L, W);
            
            long maxCircles = availableLength / diameter;
            
            System.out.println(maxCircles);
        }
        sc.close();
    }
}


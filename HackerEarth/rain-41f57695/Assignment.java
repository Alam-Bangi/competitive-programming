import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long s = sc.nextLong();
            
            long minClouds = (l + s - 1) / s;
            long maxClouds = r / s;
            
            if (minClouds > maxClouds) {
                System.out.println("-1 -1");
            } else {
                System.out.println(minClouds + " " + maxClouds);
            }
        }
        
        sc.close();
    }
}


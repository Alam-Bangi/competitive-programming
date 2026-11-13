import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long sumA = 0;
        int countA = 0;
        for (int i = 0; i < n; i++) {
            long val = sc.nextLong();
            if (val == -1) {
                countA++;
            } else {
                sumA += val;
            }
        }
        
        long sumB = 0;
        int countB = 0;
        for (int i = 0; i < n; i++) {
            long val = sc.nextLong();
            if (val == -1) {
                countB++;
            } else {
                sumB += val;
            }
        }
        
        if (countA > 0 && countB > 0) {
            System.out.println("Infinite");
        } else if (countA == 0 && countB == 0) {
            System.out.println(sumA == sumB ? 1 : 0);
        } else if (countA > 0) {
            long diff = sumB - sumA;
            if (diff < 0) {
                System.out.println(0);
            } else if (countA == 1) {
                System.out.println(1);
            } else { 
                System.out.println(diff + 1);
            }
        } else { 
            long diff = sumA - sumB;
            if (diff < 0) {
                System.out.println(0);
            } else if (countB == 1) {
                System.out.println(1);
            } else { 
                System.out.println(diff + 1);
            }
        }        
        sc.close();
    }
}

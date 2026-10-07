import java.util.Arrays;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        
        while (t > 0) {
            int n = sc.nextInt(); 
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }            
            Arrays.sort(a);
            
            int moves = 0;
            int i = 0;
            while (i < n) {
                if (i + 1 < n && a[i + 1] - a[i] <= 2) {
                    moves++; 
                    i += 2;  
                } else {
                    moves++; 
                    i += 1;  
                }
            }
            System.out.println(moves);
            t--;
        }
        sc.close();
    }
}


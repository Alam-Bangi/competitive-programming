import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            int operations = 0;
            int i = 0;
            
            while (i < n) {
                operations++;
                
                while (i < n && arr[i] == 0) {
                    i++;
                }
                
                while (i < n && arr[i] == 1) {
                    i++;
                }
            }                
            System.out.println(operations);
        }
        sc.close();
    }
}

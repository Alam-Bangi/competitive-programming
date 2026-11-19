import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 

        int[] maxPrice = new int[m + 1];

        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            int box = sc.nextInt();
            if (price > maxPrice[box]) {
                maxPrice[box] = price;
            }
        }
        long totalSum = 0;
        for (int i = 1; i <= m; i++) {
            totalSum += maxPrice[i];
        }
        System.out.println(totalSum);
        sc.close();
    }
}

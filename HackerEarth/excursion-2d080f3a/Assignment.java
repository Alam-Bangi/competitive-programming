import java.util.*;

class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int b = sc.nextInt();
            int g = sc.nextInt();
            int k = sc.nextInt();

            int rooms = (b / k) + (g / k);

            if (b % k != 0) {
                rooms++;
            }
            if (g % k != 0) {
                rooms++;
            }
            System.out.println(rooms);
        }
    }
}


import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if (s.charAt(s.length() - 1) == '6') {
            System.out.println(-1);
            sc.close();
            return;
        }

        int girls = 0;
        for (int i = 0; i < s.length(); i++) {
            char roll = s.charAt(i);

            if (roll < '1' || roll > '6') {
                System.out.println(-1);
                sc.close();
                return;
            }
            if (roll != '6') {
                girls++;
            }
        }
        System.out.println(girls);
        sc.close();
    }
}

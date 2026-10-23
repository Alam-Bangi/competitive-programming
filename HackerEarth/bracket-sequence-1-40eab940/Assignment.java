import java.util.Scanner;

class TestClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int counta = 0, countb = 0;
        int balance = 0, minBalance = 0, totalCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                counta++;
                balance++;
            } else {
                countb++;
                balance--;
            }

            if (balance < minBalance) {
                minBalance = balance;
                totalCount = 0;
            }

            if (balance == minBalance) {
                totalCount++;
            }
        }

        if (counta == countb)
            System.out.println(totalCount);
        else
            System.out.println(0);

        sc.close();
    }
}

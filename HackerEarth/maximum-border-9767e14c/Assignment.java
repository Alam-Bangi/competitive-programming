import java.util.Scanner;

public class MaximumBorders {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        char[][] shapes;
        for (int n = 0; n < testCases; n++) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();
            shapes = new char[rows][columns];
            String s = "";
            for (int i = 0; i < rows; i++) {
                    s = sc.next();
                for (int j = 0; j < columns; j++) {
                    shapes[i][j] = s.charAt(j);
                }
            }

            int c = 0;
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (c < count) {
                    c = count;
                }
                count = 0;
                for (int j = 0; j < columns; j++) {
                    if (shapes[i][j] == ('#')) {
                        count++;
                        if (shapes[i][j + 1] == ('.')) {
                            break;
                        }
                    }   
                }
            }
            if (c > count) {
                System.out.println(c);
            } else {
                System.out.println(count);
            }
        }
    }
}

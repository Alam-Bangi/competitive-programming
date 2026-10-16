import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder str = new StringBuilder(s);

        while (str.indexOf("/") != -1) {
            int start = str.lastIndexOf("/");
            int end = str.indexOf("\\", start);

            String rev = new StringBuilder(str.substring(start + 1, end))
                            .reverse().toString();

            str.replace(start, end + 1, rev);
        }

        System.out.println(str);
        sc.close();
    }
}


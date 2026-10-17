import java.util.Scanner;
import java.util.Arrays;

public class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            String s = sc.next();
            
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            
            boolean isPalindrome = true;
            int left = 0;
            int right = chars.length - 1;
            
            while (left < right) {
                if (chars[left] != chars[right]) {
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }
            
            if (isPalindrome) {
                System.out.println("-1");
            } else {
                System.out.println(new String(chars));
            }
        }
        sc.close();
    }
}

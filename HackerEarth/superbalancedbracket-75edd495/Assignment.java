import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder output = new StringBuilder();
        
        while (t-- > 0) {
            String s = sc.next();
            int rightClose = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    rightClose++;
                }
            }
            
            int leftOpen = 0;
            int maxK = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    leftOpen++;
                } else {
                    rightClose--;
                }
                
                int currentK = Math.min(leftOpen, rightClose);
                if (currentK > maxK) {
                    maxK = currentK;
                }
            }   
            output.append(2 * maxK).append("\n");
        }
        System.out.print(output.toString());        
        sc.close();
    }
}


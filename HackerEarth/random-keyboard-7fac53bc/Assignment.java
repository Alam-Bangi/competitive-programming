import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] keyboard = new String[N];
         for(int i_keyboard = 0; i_keyboard < N; i_keyboard++)
         {
         	keyboard[i_keyboard] = br.readLine();
         }
         String word = br.readLine();

         int out_ = solve(N, keyboard, word);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int solve(int N, String[] keyboard, String word){
       // Write your code here
        int result = 0;
        for (int i = 0; i < N; i++) {
            Set<Character> keys = new HashSet<>();
            for (char ch : keyboard[i].toCharArray()) {
                keys.add(ch);
            }
            boolean valid = true;

            for (char ch : word.toCharArray()) {
                if (!keys.contains(ch)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result = 1;
                break;
            }
        }
        return result;
    }
}

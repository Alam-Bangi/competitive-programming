import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String S = br.readLine();
         String[] comments = new String[N];
         for (int i = 0; i < N; i++){
               comments[i] = br.readLine();
         }
         int out_ = solution(N, S, comments);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int solution(int N, String S, String[] comments){
       // Write your code here
        int result = 0;
        String lowerS = S.toLowerCase();

        for (String commentStr : comments) {
            if (commentStr != null) {
                String[] individualComments = commentStr.split(" ");
                
                for (String comment : individualComments) {
                    if (!comment.isEmpty() && comment.toLowerCase().contains(lowerS)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

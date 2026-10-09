import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_C = br.readLine().split(" ");
         int[] C = new int[N];
         for(int i_C = 0; i_C < arr_C.length; i_C++)
         {
         	C[i_C] = Integer.parseInt(arr_C[i_C]);
         }

         int[] out_ = solution(N, C);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] solution(int N, int[] C){

            int[] stack = new int[N];
            int top = -1;

            int[] result = new int[N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (C[i] == 0) {
                    result[count] = stack[top];
                    count++;
                    top--;
                } else {
                    top++;
                    stack[top] = C[i];
                }
            }
            return Arrays.copyOf(result, count);
    } 
}

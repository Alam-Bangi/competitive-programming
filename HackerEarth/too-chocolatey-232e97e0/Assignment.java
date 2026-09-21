import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i_arr = 0; i_arr < arr_arr.length; i_arr++)
            {
            	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }

            String out_ = solve(n, arr);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static String solve(int n, int[] A){
       // Write your code here
        String result = "";

        Arrays.sort(A);
        
        long alexScore = 0;
        long bobScore = 0;
        int turn = 0; 
        
        int i = N - 1;
        while (i >= 0) {
            int currentVal = A[i];
            int count = 0;
            
            while (i >= 0 && A[i] == currentVal) {
                count++;
                i--;
            }
            
            if (count == 1) {
                if (turn == 0) {
                    alexScore += currentVal;
                } else {
                    bobScore += currentVal;
                }
                turn = 1 - turn;
            } else {
                alexScore += currentVal;
                bobScore += currentVal;
            }
        }
        
        if (alexScore > bobScore) {
            result = "Alex";
        } else {
            result = "Bob";
        }
    }
    return result;
}

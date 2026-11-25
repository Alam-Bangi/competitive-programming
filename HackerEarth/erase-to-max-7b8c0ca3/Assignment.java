import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_Arr = br.readLine().split(" ");
            int[] Arr = new int[N];
            for(int i_Arr=0; i_Arr<arr_Arr.length; i_Arr++)
            {
            	Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
            }

            long out_ = getResult(Arr);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static long getResult(int[] Arr){
        long totalSum = 0;
        Map<Integer, Long> freq = new HashMap<>();
        
        for (int num : Arr) {
            totalSum += num;
            freq.put(num, freq.getOrDefault(num, 0L) + 1L);
        }
        
        long maxSum = Long.MIN_VALUE;        
        for (Map.Entry<Integer, Long> entry : freq.entrySet()) {
            long val = entry.getKey();
            long count = entry.getValue();
            long remainingSum = totalSum - (val * count);
            
            if (remainingSum > maxSum) {
                maxSum = remainingSum;
            }
        }
        return maxSum;
    }
}

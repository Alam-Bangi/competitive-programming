import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_arr = br.readLine().split(" ");
         int[] arr = new int[n];
         for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
         {
         	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
         }

         int[] out_ = funGame(arr);
         System.out.print(out_[0]);
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] funGame(int[] arr){
        int n = arr.length;
        int i = 0;     
        int j = n - 1; 
        
        List<Integer> resultList = new ArrayList<>();
        
        while (i < n && j >= 0) {
            if (arr[i] > arr[j]) {
                resultList.add(1);
                j--; 
            } else if (arr[i] < arr[j]) {
                resultList.add(2);
                i++; 
            } else {
                resultList.add(0);
                i++; 
                j--;
            }
        }
        
        int[] out = new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) {
            out[k] = resultList.get(k);
        }
        return out;
    }
}


import java.io.*;
import java.util.*;

public class MakeAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            int out_ = solve(N, A);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    static int solve(int N, int[] A){
        if (N == 1) {
            return (A[0] == 0) ? 0 : -1;
        }

        long totalSum = 0;
        int maxElement = 0;

        for (int i = 0; i < N; i++) {
            totalSum += A[i];
            if (A[i] > maxElement) {
                maxElement = A[i];
            }
        }

        if (totalSum % (N - 1) != 0) {
            return -1;
        }

        long k = totalSum / (N - 1);

        if (k >= maxElement) {
            return (int) k;
        } else {
            return -1;
        }
    }
}


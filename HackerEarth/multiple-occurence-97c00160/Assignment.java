import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
            HashMap<Integer, Integer> lastOccurrence = new HashMap<>();
            
            for (int i = 1; i <= n; i++) {
                int val = sc.nextInt();
                
                if (!firstOccurrence.containsKey(val)) {
                    firstOccurrence.put(val, i);
                }
                lastOccurrence.put(val, i);
            }
            
            long totalSum = 0;
            
            for (int val : firstOccurrence.keySet()) {
                int first = firstOccurrence.get(val);
                int last = lastOccurrence.get(val);
                totalSum += (last - first); 
            }
            System.out.println(totalSum);
        }
    }
}


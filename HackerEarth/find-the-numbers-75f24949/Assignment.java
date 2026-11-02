import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}


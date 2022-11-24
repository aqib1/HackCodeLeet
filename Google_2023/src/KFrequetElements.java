import java.util.*;

public class KFrequetElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> valueByCount = new HashMap<>();
        int [] result = new int [k];
        for(int num : nums) {
            int count = valueByCount.getOrDefault(num, 0);
            valueByCount.put(num, count + 1);
        }
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        for(Map.Entry<Integer, Integer> entry : valueByCount.entrySet()) {
            maxHeap.offer(entry);
        }
        for(int x=0; x< k; x++) {
            result[x] = Objects.requireNonNull(maxHeap.poll()).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] {1,1,1,2,2,3,3,3,3,3,3}, 2)));
    }
}

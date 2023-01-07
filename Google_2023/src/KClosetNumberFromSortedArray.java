import java.util.*;

public class KClosetNumberFromSortedArray {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(k > arr.length) return null;
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a - x) == Math.abs(b - x)) {
                return Integer.compare(a, b);
            } else return
            Math.abs(a - x) - Math.abs(b - x);
        });
        Arrays.stream(arr).forEach(minHeap::offer);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(minHeap.poll());
        }
        return result.stream().sorted().toList();
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[] {0,0,1,2,3,3,4,7,7,8},  3, 5));
    }

}

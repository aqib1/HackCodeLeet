import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinimumUniqueArraySum {
	public static void main(String[] args) {
		System.out.println(getMinimumUniqueSum(new int [] {3, 4, 6, 8}));
		
		// 1 + 2 + 3 + 8 + 7 = 21 
	}
	public static int getMinimumUniqueSum(int [] arr) {
		if(Objects.isNull(arr) || arr.length == 0)
			return 0;
		Arrays.sort(arr);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr.length);
		minHeap.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		int sum = 0;
		while(!minHeap.isEmpty()) {
			int current = minHeap.poll();
			if(!minHeap.isEmpty() && minHeap.peek() == current) {
				minHeap.add(current);
				minHeap.add(minHeap.poll() + 1);
			} else
			sum += current;
		}
		
		return sum;
	}
}

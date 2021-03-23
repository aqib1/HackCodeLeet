import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumUniqueArraySum {
	public static void main(String[] args) {
		System.out.println(getMinimumUniqueSumBetter(new int [] {3, 2, 1, 2, 7}));
		
		// 1 + 2 + 3 + 8 + 7 = 21 
	}
	
	public static int getMinimumUniqueSumBetter(int [] arr) {
		if(Objects.isNull(arr) || arr.length == 0)
			return 0;
		Set<Integer> set = new HashSet<>();
		IntStream.range(0, arr.length).forEach(x -> {
			int currValue = arr[x];
			while(set.contains(currValue)) {
				++currValue;
			}
			set.add(currValue);
		});
		
		return set.stream().reduce(0, Integer::sum);
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

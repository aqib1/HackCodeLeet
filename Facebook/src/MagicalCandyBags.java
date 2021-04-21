import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class MagicalCandyBags {

	public static int maxCandies(int[] arr, int k) {
		if (Objects.isNull(arr) || arr.length == 0) {
			return 0;
		}
		Queue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
		IntStream.range(0, arr.length).forEach(i -> max_heap.offer(arr[i]));

		int candies = 0;
		while (k > 0) {
			int max = max_heap.poll();
			max_heap.offer(max / 2);
			candies += max;
			k--;
		}

		return candies;
	}

	public static void main(String[] args) {
		System.out.println(maxCandies(new int[] { 2, 1, 7, 4, 2 }, 3));
	}
}

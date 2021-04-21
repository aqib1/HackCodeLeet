import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMaxProduct {

	public static int[] findMaxProduct(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0) {
			return new int[] {};
		}
		if (arr.length == 1) {
			return new int[] { -1 };
		}

		int[] result = new int[arr.length];
		Queue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			max_heap.offer(arr[i]);

			if (max_heap.size() < 3) {
				result[i] = -1;
			} else {
				int first = max_heap.poll();
				int second = max_heap.poll();
				int third = max_heap.poll();
				result[i] = first * second * third;

				max_heap.offer(first);
				max_heap.offer(second);
				max_heap.offer(third);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findMaxProduct(new int[] { 2, 1, 2, 1, 2 })));
	}
}

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Largest_Triple_Products {
	private static int[] findMaxProduct(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0)
			return null;
		if (arr.length == 1)
			return new int[] { -1 };

		int[] result = new int[arr.length];
		Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			maxHeap.offer(arr[i]);
			if (i >= 2) {
				int x = maxHeap.poll();
				int y = maxHeap.poll();
				int z = maxHeap.poll();
				result[i] = x * y * z;
				maxHeap.offer(x);
				maxHeap.offer(y);
				maxHeap.offer(z);
			} else {
				result[i] = -1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findMaxProduct(new int[] { 2, 1, 2, 1, 2 })));
	}
}

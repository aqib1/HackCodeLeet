import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianStream {

	/**
	 * n = 4, arr = [5, 15, 1, 3], output = [5, 10, 5, 4]
	 */
	private static int[] findMedian(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0) {
			return new int[] {};
		}
		Queue<Integer> minHeap = new PriorityQueue<>();
		int[] median = new int[arr.length];

		for (int i = 0; i < median.length; i++) {
			minHeap.offer(arr[i]);

			int[] tmp = new int[minHeap.size()];
			for (int j = 0; j < tmp.length; j++)
				tmp[j] = minHeap.poll();

			if (tmp.length % 2 == 0) {
				int beforeMid = (tmp.length / 2) - 1;
				median[i] = (tmp[beforeMid] + tmp[beforeMid + 1]) / 2;
			} else {
				int mid = tmp.length / 2;
				median[i] = tmp[mid];
			}
			
			for (int j = 0; j < tmp.length; j++)
				minHeap.offer(tmp[j]);
		}
		return median;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findMedian(new int[] {5, 15, 1, 3})));
	}

}

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median_Stream {
	public static int[] findMedian(int[] arr) {
		int[] median = new int[arr.length];
		Queue<Integer> minHeap = new PriorityQueue<>();
		for (int x = 0; x < arr.length; x++) {
			minHeap.offer(arr[x]);
			int[] tmp = new int[minHeap.size()];
			for (int i = 0; i < tmp.length; i++)
				tmp[i] = minHeap.poll();
			if (tmp.length % 2 == 0) {
				int index = tmp.length / 2;
				median[x] = (tmp[index] + tmp[index - 1]) / 2;
			} else {
				median[x] = tmp[tmp.length / 2];
			}
			for (int i = 0; i < tmp.length; i++)
				minHeap.offer(tmp[i]);
		}

		return median;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findMedian(new int[] { 5, 15, 1, 3 })));
	}
}

package algos;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class ArrayPartitions {

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 1, 1, 1, 1, 1, 1 }));
	}

	// time complexity Onlog(n) * O(n)^2 = O(n)^2
	// Space complexity O(1) if we ignore that boxed Integer array
	private static boolean canPartition(int[] d) {
		if (d == null || d.length <= 1) {
			return false;
		}
		Integer[] data = IntStream.of(d).boxed().toArray(Integer[]::new);
		Arrays.sort(data, Collections.reverseOrder());
		int limit = (Arrays.stream(data).reduce(0, (a, b) -> a + b)) / 2;
		for (int x = 0; x < data.length; x++) {
			int sum = data[x];
			for (int y = (x + 1); y < data.length; y++) {
				if (sum + data[y] == limit)
					return true;

				if (sum + data[y] < limit)
					sum += data[y];

			}
		}
		return false;
	}
}

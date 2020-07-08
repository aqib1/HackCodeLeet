package algos;

import java.util.stream.IntStream;

public class ArrayPartitions {

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 1, 1, 1, 1, 1, 1 }));
	}

	// time complexity O(n)
	// Space complexity O(n) where n is the len(d)/2 + 1
	private static boolean canPartition(int[] d) {
		if (d == null || d.length <= 1) {
			return false;
		}
		int limit = IntStream.range(0, d.length).map(x -> d[x]).sum();
		if (limit % 2 != 0)
			return false;
		limit = limit / 2;
		boolean[] visited = new boolean[limit + 1];
		visited[0] = true;

		// 6 -> {2} -> {6-2} -> {3}
		for (int x : d) {
			for (int j = limit; j >= x; j--) {
				visited[j] = visited[j] || visited[j - x];
			}
		}

		return visited[limit];
	}
}

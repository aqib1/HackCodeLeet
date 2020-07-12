package algos;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KNearestPostOfficeToYou {

	public static void main(String[] args) {

		System.out.println(Arrays.deepToString(
				KNearestPostOffices(new int[][] { { -16, 5 }, { -1, 2 }, { 4, 3 }, { 10, -2 }, { 0, 3 }, { -5, -9 } },
						new int[] { 0, 0 }, 3)));
	}

	// Time complexity is O(n) and space complexity O(n+m)
	public static int[][] KNearestPostOffices(int[][] postOffices, int[] origin, int k) {
		if (postOffices == null || postOffices.length == 0)
			return null;
		int[][] nearestPostOffices = new int[k][];
		PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((m, n) -> Double.compare(m[1], n[1]));
		for (int point = 0; point < postOffices.length; point++) {
			int[] Point = postOffices[point];
			double distance = Math.sqrt(Math.pow(origin[0] - Point[0], 2) + Math.pow(origin[1] - Point[1], 2));
			priorityQueue.add(new double[] { point, distance });
		}
		for (int x = 0; x < k; x++) {
			nearestPostOffices[x] = postOffices[(int) priorityQueue.poll()[0]];
		}
		return nearestPostOffices;
	}
}

package leetcode.arrays;

import java.util.PriorityQueue;

public class KClosedToOrigin {

	// On(logn)
	public int[][] kClosest(int[][] points, int K) {
		// sqrt(a[0] squre + a[1] square)
		PriorityQueue<double[]> pq = new PriorityQueue<>((x, y) -> Double.compare(x[1], y[1]));

		for (int x = 0; x < points.length; x++) {
			double value = Math.sqrt(Math.pow(points[x][0], 2) + Math.pow(points[x][1], 2));
			pq.add(new double[] { x, value });
		}
		int[][] result = new int[K][];
		for (int x = 0; x < K; x++) {
			result[x] = points[(int) pq.poll()[0]];
		}

		return result;
	}
}

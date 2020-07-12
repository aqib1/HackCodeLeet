package algos;

import java.util.PriorityQueue;

public class KClosestPointsToOriginPoint {

	// K closet points to Origin (0,0)

	public int[][] kClosest(int[][] points, int K) {
		if (points == null || points.length == 0)
			return null;

		// Take a min heap
		PriorityQueue<double[]> minHeap = new PriorityQueue<>((m, n) -> Double.compare(m[1], n[1]));

		int[][] result = new int[K][];

		// distance formula between two points P(x1,y1) and Q(x2,y2) is
		// distance = squrt [(x2 - x1)^2 + (y2-y1)^2] where Q > P
		for (int point = 0; point < points.length; point++) {
			// we need to find distance of each point from origin (0,0)
			// as we know from origin the formula will be (x2 - 0)^2 and (y2 - 0)^2 and then
			// square root
			// so we do not need to minus zero as it will not have any impact
			int[] Point = points[point];
			double distance = Math.sqrt(Math.pow(Point[0], 2) + Math.pow(Point[1], 2));
			minHeap.add(new double[] { point, distance });
		}
		for (int x = 0; x < K; x++) {
			result[x] = points[(int) minHeap.poll()[0]];
		}

		return result;
	}
}

package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShippingRouteOptimal {

	// Time complexity is O(n)2 and OLog(n) over all O(n)2 and space complexity is
	// O(n)
	public static List<int[]> getRoutesOpt(int[][] forwardRoutes, int[][] backwardRoutes, int maxTravelDist) {
		// Max heap (PriorityQueue default behavior is min heap so we will apply reverse
		// comparator)
		PriorityQueue<Route> max_heap = new PriorityQueue<>(
				(r1, r2) -> Integer.compare(r2.getDistance(), r1.getDistance()));
		List<int[]> result = new ArrayList<int[]>();
		int max_dist = Integer.MIN_VALUE;
		for (int f = 0; f < forwardRoutes.length; f++) {
			for (int b = 0; b < backwardRoutes.length; b++) {
				int sumDist = forwardRoutes[f][1] + backwardRoutes[b][1];
				if (sumDist <= maxTravelDist)
					max_heap.add(new Route(sumDist, new int[] { forwardRoutes[f][0], backwardRoutes[b][0] }));
			}
		}

		while (!max_heap.isEmpty()) {
			Route route = max_heap.poll();
			if (max_dist <= route.distance) {
				result.add(route.getRoutes());
				max_dist = route.distance;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<int[]> result = getRoutesOpt(new int[][] { { 1, 3000 }, { 2, 5000 }, { 3, 7000 }, { 4, 10000 } },
				new int[][] { { 1, 2000 }, { 2, 3000 }, { 3, 4000 }, { 4, 5000 } }, 10000);
		for (int[] r : result)
			System.out.println(Arrays.toString(r));
	}

	static class Route {
		private int distance;
		private int[] routes;

		private Route() {
		}

		private Route(int distance, int[] routes) {
			this.distance = distance;
			this.routes = routes;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int[] getRoutes() {
			return routes;
		}

		public void setRoutes(int[] routes) {
			this.routes = routes;
		}

	}
}

package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosetLocations {
	class PairInt {
		int first, second;

		public PairInt() {
		}

		PairInt(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	class PairAnalytics {
		PairInt pairInt;
		double distance;

		public PairAnalytics(PairInt pairInt, double distance) {
			this.pairInt = pairInt;
			this.distance = distance;
		}
	}

	public List<PairInt> closestLocations(int totalCrates, List<PairInt> allLocations, int truckCapacity) {

		// Take a min heap
		PriorityQueue<PairAnalytics> minHeap = new PriorityQueue<>((m, n) -> Double.compare(m.distance, n.distance));

		List<PairInt> result = new ArrayList<>();

		// distance formula between two points P(x1,y1) and Q(x2,y2) is
		// distance = squrt [(x2 - x1)^2 + (y2-y1)^2] where Q > P
		for (int point = 0; point < allLocations.size(); point++) {
			// we need to find distance of each point from origin (0,0)
			// as we know from origin the formula will be (x2 - 0)^2 and (y2 - 0)^2 and then
			// square root
			// so we do not need to minus zero as it will not have any impact
			PairInt pair = allLocations.get(point);
			double distance = Math.sqrt(Math.pow(pair.first, 2) + Math.pow(pair.second, 2));
			minHeap.add(new PairAnalytics(pair, distance));
		}
		for (int x = 0; x < truckCapacity; x++) {
			result.add(minHeap.poll().pairInt);
		}

		return result;
	}
}

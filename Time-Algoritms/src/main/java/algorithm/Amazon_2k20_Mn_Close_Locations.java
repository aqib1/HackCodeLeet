package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Amazon_2k20_Mn_Close_Locations {

	class PairInt {
		int first, second;

		public PairInt() {

		}

		public PairInt(int first, int second) {
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

		PriorityQueue<PairAnalytics> minHeap = new PriorityQueue<>((m, n) -> Double.compare(m.distance, n.distance));

		List<PairInt> result = new ArrayList<>();

		for (int point = 0; point < allLocations.size(); point++) {
			PairInt pair = allLocations.get(point);
			double distance = Math.sqrt(Math.pow(pair.first, 2) + Math.pow(pair.second, 2));
			minHeap.add(new PairAnalytics(pair, distance));
		}

		for (int x = 0; x < truckCapacity; x++) {
			result.add(minHeap.poll().pairInt);
		}

		return result;
	}

	public static void main(String[] args) {

	}
}

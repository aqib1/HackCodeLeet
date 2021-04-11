import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution4 {

	class Pair {
		int from;
		int to;

		public Pair(int from, int to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + from;
			result = prime * result + to;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (from != other.from)
				return false;
			if (to != other.to)
				return false;
			return true;
		}

	}

	class solution {

		public int maxShared(int friendsNodes, List<Integer> friendsFrom, List<Integer> friendsTo,
				List<Integer> friendsWeight) {

			if (friendsFrom.isEmpty() || friendsTo.isEmpty()) {
				return 0;
			}

			Map<Pair, Integer> pairCounts = new HashMap<>();

			Map<Integer, List<Pair>> weightPairCounts = new HashMap<>();
			for (int i = 0; i < friendsWeight.size(); i++) {
				List<Pair> pair = weightPairCounts.get(friendsWeight.get(i));
				if (pair == null) {
					pair = new ArrayList<Pair>();
					pair.add(new Pair(friendsFrom.get(i), friendsTo.get(i)));
					weightPairCounts.put(friendsWeight.get(i), pair);
				} else {
					pair.add(new Pair(friendsFrom.get(i), friendsTo.get(i)));
					weightPairCounts.put(friendsWeight.get(i), pair);
				}
			}

			for (int i = 0; i < friendsFrom.size(); i++) {
				Integer count = pairCounts.get(new Pair(friendsFrom.get(i), friendsTo.get(i)));
				if (count == null)
					pairCounts.put(new Pair(friendsFrom.get(i), friendsTo.get(i)), 1);
				else
					pairCounts.put(new Pair(friendsFrom.get(i), friendsTo.get(i)), count + 1);
			}

			Set<Pair> count1 = weightPairCounts.values().stream()
					.flatMap(pairs -> pairs.stream().filter(pair -> pairs.contains(pair))).collect(Collectors.toSet());
			count1.stream().forEach(entry -> System.out.println(entry.from + " : " + entry.to));
			PriorityQueue<Map.Entry<Pair, Integer>> maxHeap = new PriorityQueue<>(
					(o1, o2) -> o2.getValue().compareTo(o1.getValue()));

			pairCounts.entrySet().stream().forEach(entry -> maxHeap.add(entry));

			Entry<Pair, Integer> firstPair = maxHeap.poll();
			int max = firstPair.getKey().from * firstPair.getKey().to;
			int count = firstPair.getValue();
			while (!maxHeap.isEmpty()) {
				Entry<Pair, Integer> pair = maxHeap.poll();
				if (count != pair.getValue())
					return max;

				max = Math.max(max, pair.getKey().from * pair.getKey().to);

			}
			return max;

		}

	}
	
	public static void main(String[] args) {
//		System.out.print(maxShared(7, Arrays.asList(1, 1, 2, 2, 2, 4, 4), Arrays.asList(2, 2, 3, 3, 4, 5, 5),
//				Arrays.asList(1, 2, 1, 3, 3, 1, 2)));

	}
}

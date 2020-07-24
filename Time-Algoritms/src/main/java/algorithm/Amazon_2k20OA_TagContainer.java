package algorithm;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Amazon_2k20OA_TagContainer {
	public static class PairString {
		private String pair1;
		private String pair2;

		public PairString(String pair1, String pair2) {
			this.pair1 = pair1;
			this.pair2 = pair2;
		}

		public String getPair1() {
			return pair1;
		}

		public void setPair1(String pair1) {
			this.pair1 = pair1;
		}

		public String getPair2() {
			return pair2;
		}

		public void setPair2(String pair2) {
			this.pair2 = pair2;
		}

	}

	public static void main(String[] args) {
		PairString[] pairs = { //
				new PairString("item1", "item2"), // -> item1, item3, item2
				new PairString("item3", "item2"), //
				new PairString("item5", "item6"), //
				new PairString("item2", "item5")//
		};

		System.out.println(longestPairTag(pairs));
	}

	// Time complexity O(n2) and space is O(n)
	public static List<String> longestPairTag(PairString[] pairs) {
		// using heap map with time complexity Ologn
		PriorityQueue<List<String>> max_heap = new PriorityQueue<>(//
				(l1, l2) -> Integer.compare(l2.size(), l1.size()));//
		Arrays.sort(pairs, (ps1, ps2) -> ps1.getPair2().compareTo(ps2.getPair2()));

		for (int pair = 0; pair < pairs.length; pair++) {
			Set<String> buildList = new LinkedHashSet<>(Arrays.asList(pairs[pair].getPair1(), pairs[pair].getPair2()));
			for (int inner = pair + 1; inner < pairs.length; inner++) {
				mergeTag(buildList, pairs[inner]);
			}
			max_heap.add(buildList.stream().collect(Collectors.toList()));
		}
		return max_heap.poll();
	}

	private static void mergeTag(Set<String> buildList, PairString pairString) {
		if (buildList.contains(pairString.getPair1()) && buildList.contains(pairString.getPair2()))
			return;
		if (buildList.contains(pairString.getPair1())) {
			buildList.add(pairString.getPair2());
		} else if (buildList.contains(pairString.getPair2())) {
			buildList.add(pairString.getPair1());
		}

	}
}
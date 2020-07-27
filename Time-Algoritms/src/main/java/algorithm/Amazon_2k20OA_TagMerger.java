package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Amazon_2k20OA_TagMerger {

	public static class PairString {
		private String first;
		private String second;

		public PairString(String first, String second) {
			this.first = first;
			this.second = second;
		}

	}

	public static void main(String[] args) {
		List<PairString> pairs = Arrays.asList( //
				new PairString("item1", "item2"), // -> item1, item3, item2
				new PairString("item3", "item4"), //
				new PairString("item5", "item6"), //
				new PairString("item2", "item5")//
		);

		System.out.println(largestItemAssociation(pairs));
	}

	// Time complexity O(n2) and space is O(n)
	public static List<String> largestItemAssociation(List<PairString> pairs) {
		// using heap map with time complexity Ologn
		PriorityQueue<List<String>> max_heap = new PriorityQueue<>(//
				(l1, l2) -> Integer.compare(l2.size(), l1.size()));//
		Collections.sort(pairs, (a, b) -> a.first.compareTo(b.first));

		for (int pair = 0; pair < pairs.size(); pair++) {
			List<String> buildList = new ArrayList<>(Arrays.asList(pairs.get(pair).first, pairs.get(pair).second));
			for (int inner = pair + 1; inner < pairs.size(); inner++) {
				if (allSame(buildList, pairs.get(inner))) {
					continue;
				} else if (buildList.get(buildList.size() - 1).equals(pairs.get(inner).first)) {
					buildList.add(pairs.get(inner).second);
				}
			}
			max_heap.add(buildList);
		}

		return max_heap.poll();
	}

	private static boolean allSame(List<String> buildList, PairString pairString) {
		if (buildList.size() > 2)
			return false;

		return buildList.get(0).equals(pairString.first) //
				&& buildList.get(1).equals(pairString.second);
	}
}

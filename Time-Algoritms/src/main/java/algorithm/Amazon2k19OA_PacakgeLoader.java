package algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Amazon2k19OA_PacakgeLoader {
	private static final int MARGIN = 30;

	// Time complexity O(n)2 and OlogN over all will be O(n)2 and space will be O(n)
	public static int[] loadPackage(int packages[], int space) {
		// Max heap (PriorityQueue default behavior is min heap so we will apply reverse
		// comparator)
		PriorityQueue<Package> max_heap = new PriorityQueue<>((p1, p2) -> {
			int v1Comp = Integer.compare(p1.getValues()[0], p2.getValues()[0]);
			int v2Comp = Integer.compare(p1.getValues()[1], p2.getValues()[1]);
			if (v1Comp > 1 || v2Comp > 1 || v1Comp == 0 && v2Comp == 0)
				return -1;

			return 1;
		});
		for (int x = 0; x < packages.length; x++) {
			for (int y = x + 1; y < packages.length; y++) {
				int weight = packages[x] + packages[y];
				if (weight == (space - MARGIN)) {
					max_heap.add(new Package(new int[] { x, y }, new int[] { packages[x], packages[y] }));
				}
			}
		}

		return max_heap.isEmpty() ? new int[] {} : max_heap.poll().getIndexes();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(loadPackage(new int[] { 60, 60, 60, 60, 60 }, 90)));
	}

	static class Package {
		private int[] indexes;

		private int[] values;

		public Package() {
			this(null, null);
		}

		public Package(int[] indexes, int[] values) {
			this.indexes = indexes;
			this.values = values;
		}

		public int[] getIndexes() {
			return indexes;
		}

		public void setIndexes(int[] indexes) {
			this.indexes = indexes;
		}

		public int[] getValues() {
			return values;
		}

		public void setValues(int[] values) {
			this.values = values;
		}

	}

}

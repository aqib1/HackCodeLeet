package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervels {

	// O(n) * Onlogn in the case if intervals are not sorted
	// Space is O(n)
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return intervals;
		Collections.sort(Arrays.asList(intervals), (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> merger = new ArrayList<>();
		merger.add(intervals[0]);
		int mergePointer = 0;
		for (int x = 1; x < intervals.length; x++) {
			int[] lastInterval = merger.get(mergePointer);
			if (lastInterval[0] <= intervals[x][0] && lastInterval[1] >= intervals[x][0]) {
				lastInterval[1] = Math.max(lastInterval[1], intervals[x][1]);
			} else {
				merger.add(intervals[x]);
				mergePointer++;
			}
		}
		return merger.toArray(new int[merger.size()][]);
	}
}

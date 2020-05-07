package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		if (Objects.isNull(intervals) || intervals.length == 0)
			return new int[0][];
		Collections.sort(Arrays.asList(intervals), (a, b) -> (a[0] < b[0]) ? -1 : (a[0] == b[0]) ? 0 : 1);
		List<int[]> merged = new ArrayList<int[]>();
		int mergerPointer = 0;
		merged.add(intervals[0]);
		for (int x = 1; x < intervals.length; x++) {
			int[] data = merged.get(mergerPointer);
			if (intervals[x][0] <= data[1]) {
				if (data[1] < intervals[x][1])
					data[1] = intervals[x][1];
			} else {
				merged.add(intervals[x]);
				mergerPointer++;
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}

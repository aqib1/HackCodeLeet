package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervelsI {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(merge(new int[][] { //
				{ 3, 12 }, //
				{ 4, 8 }, //
		})));
	}

//	Input: [[1,3],[2,6],[8,10],[15,18]]
//	Output: [[1,6],[8,10],[15,18]]

	// Time complexity O(n) * nlogn while space is O(n)
	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return intervals;

		Collections.sort(Arrays.asList(intervals), (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> merge = new ArrayList<>();
		merge.add(intervals[0]);
		int mergePointer = 0;
		for (int x = 1; x < intervals.length; x++) {
			int previous[] = merge.get(mergePointer);
			if (intervals[x][0] >= previous[0] && intervals[x][0] <= previous[1]) {
				previous[1] = Math.max(previous[1], intervals[x][1]);
			} else {
				merge.add(intervals[x]);
				mergePointer++;
			}

		}

		return merge.toArray(new int[merge.size()][]);
	}
}

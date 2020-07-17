package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimizeMemoryUsageOA22020 {
	/**
	 * Input: foregroundTasks = [1, 7, 2, 4, 5, 6] backgroundTasks = [1, 1, 2] K =
	 * 10
	 * 
	 * Output: [(1, 2)]
	 */

	public static void main(String[] args) {
		List<int[]> result = optimizeMemoryUsage(new int[] { 1, 7, 2, 4, 5, 6 }, new int[] { 1, 2, 1 }, 10);
		for (int[] r : result) {
			System.out.println(Arrays.toString(r));
		}
	}

	// Time complexity Onlogn + Onlogn + O(n)2 = 2nlogn + O(n)2 ~ O(n2)
	// Space complexity is O(n + m)
	public static List<int[]> optimizeMemoryUsage(int[] foregroundTasks, int[] backgroundTasks, int K) {
		Map<Integer, Integer> forgroundLocations = new HashMap<>();
		Map<Integer, Integer> backGroundLocations = new HashMap<>();

		for (int f = 0; f < foregroundTasks.length; f++)
			forgroundLocations.put(foregroundTasks[f], f);
		for (int b = 0; b < backgroundTasks.length; b++)
			backGroundLocations.put(backgroundTasks[b], b);

		Arrays.sort(foregroundTasks);
		Arrays.sort(backgroundTasks);

		List<int[]> optimizeMemoryUsage = new ArrayList<>();
		int lastSum = -1;
		for (int f = foregroundTasks.length - 1; f >= 0; f--) {
			if (foregroundTasks[f] == K) {
				optimizeMemoryUsage.add(new int[] { forgroundLocations.get(foregroundTasks[f]), -1 });
				continue;
			}
			for (int b = backgroundTasks.length - 1; b >= 0; b--) {
				if (backgroundTasks[b] == K) {
					optimizeMemoryUsage.add(new int[] { -1, backGroundLocations.get(backgroundTasks[b]) });
					continue;
				}
				int sum = foregroundTasks[f] + backgroundTasks[b];
				if (sum < lastSum)
					break;
				if (sum <= K) {
					optimizeMemoryUsage.add(new int[] { forgroundLocations.get(foregroundTasks[f]),
							backGroundLocations.get(backgroundTasks[b]) });
					lastSum = sum;
				}
			}
		}

		return optimizeMemoryUsage;
	}
}

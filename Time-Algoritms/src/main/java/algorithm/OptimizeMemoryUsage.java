package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class OptimizeMemoryUsage {
	public static void main(String[] args) {
		List<int[]> result = optimizeMemoryUsage(new int[] { 1, 7, 2, 4, 5, 6 }, new int[] { 1, 1, 2 }, 2);
		for (int[] r : result)
			System.out.println(Arrays.toString(r));
	}

	// Time complexity On2 + Onlogn ~ overall On2
	// Space complexity O(n+m) in case of similar element collision O(n*k + m*L)
	// where k and L is the numbers of repeated elements
	public static List<int[]> optimizeMemoryUsage(int[] foregroundTasks, int[] backgroundTasks, int K) {
		if (K == 0 || (foregroundTasks.length == 0 && backgroundTasks.length == 0))
			return Arrays.asList(new int[] { -1, -1 });
		Map<Integer, Queue<Integer>> foregroundLocations = createForegroundLocations(foregroundTasks);
		Map<Integer, Queue<Integer>> backGroundLocations = createBackgroundLocations(backgroundTasks);
		List<int[]> result = new ArrayList<int[]>();

		boolean isForegroundTaskGreater = isForegroundTaskGenerator(foregroundTasks, backgroundTasks,
				foregroundLocations, backGroundLocations);

		int last_sum = Integer.MIN_VALUE;
		Arrays.sort(foregroundTasks);
		Arrays.sort(backgroundTasks);

		for (int f = foregroundTasks.length - 1; f >= 0; f--) {
			if (foregroundTasks[f] > K)
				continue;
			int fPolled = foregroundLocations.get(foregroundTasks[f]).poll();
			if (foregroundTasks[f] == K) {
				addResult(result, isForegroundTaskGreater, fPolled, new LinkedList<>(Arrays.asList(-1)));
				last_sum = K;
			}
			for (int b = backgroundTasks.length - 1; b >= 0; b--) {
				if (backgroundTasks[b] > K || backgroundTasks[b] == Integer.MIN_VALUE)
					continue;
				if (backgroundTasks[b] == K) {
					addResult(result, isForegroundTaskGreater, -1, backGroundLocations.get(backgroundTasks[b]));
					backgroundTasks[b] = Integer.MIN_VALUE; // Stamp to skip
					last_sum = K;
					continue;
				}
				int sum = foregroundTasks[f] + backgroundTasks[b];
				if (sum > K)
					continue;
				if (last_sum <= sum) {
					addResult(result, isForegroundTaskGreater, fPolled, backGroundLocations.get(backgroundTasks[b]));
					last_sum = sum;
				}
			}
			foregroundLocations.get(foregroundTasks[f]).add(fPolled);
		}

		return result;
	}

	private static boolean isForegroundTaskGenerator(int[] foregroundTasks, int[] backgroundTasks,
			Map<Integer, Queue<Integer>> foregroundLocations, Map<Integer, Queue<Integer>> backGroundLocations) {
		boolean isForegroundTaskGreater = foregroundTasks.length >= backgroundTasks.length;
		// make foregroundTasks always bigger
		if (!isForegroundTaskGreater) {
			int[] temp = foregroundTasks;
			foregroundTasks = backgroundTasks;
			backgroundTasks = temp;

			Map<Integer, Queue<Integer>> tempMap = foregroundLocations;
			foregroundLocations = backGroundLocations;
			backGroundLocations = tempMap;
		}
		return isForegroundTaskGreater;
	}

	private static Map<Integer, Queue<Integer>> createBackgroundLocations(int[] backgroundTasks) {
		Map<Integer, Queue<Integer>> backGroundLocations = new HashMap<>();
		for (int b = 0; b < backgroundTasks.length; b++) {
			if (backGroundLocations.containsKey(backgroundTasks[b])) {
				backGroundLocations.get(backgroundTasks[b]).add(b);
			} else
				backGroundLocations.put(backgroundTasks[b], new LinkedList<>(Arrays.asList(b)));
		}
		return backGroundLocations;
	}

	private static Map<Integer, Queue<Integer>> createForegroundLocations(int[] foregroundTasks) {
		Map<Integer, Queue<Integer>> foregroundLocations = new HashMap<>();
		for (int f = 0; f < foregroundTasks.length; f++) {
			if (foregroundLocations.containsKey(foregroundTasks[f])) {
				foregroundLocations.get(foregroundTasks[f]).add(f);
			} else
				foregroundLocations.put(foregroundTasks[f], new LinkedList<>(Arrays.asList(f)));
		}
		return foregroundLocations;
	}

	private static void addResult(List<int[]> result, boolean isForegroundTaskGreater, int f, Queue<Integer> b) {
		int bpoll = b.poll();
		if (isForegroundTaskGreater) {
			result.add(new int[] { f, bpoll });
			b.add(bpoll);
		} else {
			result.add(new int[] { bpoll, f });
			b.add(bpoll);
		}

	}
}

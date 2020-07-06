package algos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchInRotatedArray {

	// Time complexity OnLog(n) and space is O(n)
	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		// resolve problem of duplicate data
		List<Integer> data = IntStream.of(nums).boxed().distinct().collect(Collectors.toList());
		System.out.println(data);
		if (data.size() == 1)
			return data.get(0) == target;
		if (data.get(0) < data.get(data.size() - 1))
			// not rotated
			return binerySearch(data, 0, data.size() - 1, target);
		int pivot = pivot(data, 0, data.size() - 1);
		if (data.get(pivot) == target)
			return true;
		if (target >= nums[0])
			return binerySearch(data, 0, pivot - 1, target);

		return binerySearch(data, pivot + 1, data.size() - 1, target);
	}

	private static int pivot(List<Integer> data, int low, int heigh) {
		int mid = low + (heigh - low) / 2;
		if (mid > low && data.get(mid - 1) > data.get(mid))
			return mid - 1;
		if (mid < heigh && data.get(mid) > data.get(mid + 1))
			return mid;
		if (data.get(mid) < data.get(low))
			return pivot(data, low, mid - 1);
		return pivot(data, mid + 1, heigh);
	}

	private static boolean binerySearch(List<Integer> data, int low, int high, int target) {
		if (low > high)
			return false;
		int mid = low + (high - low) / 2;
		if (target == data.get(mid))
			return true;
		if (target > data.get(mid))
			return binerySearch(data, mid + 1, high, target);
		return binerySearch(data, low, mid - 1, target);
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { -4, -4, -3, -3, -3, -3, -3, -3, -3, -2, -2, -2, -2, -1, -1, -1, -1, -1,
				-1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5,
				5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 10, 10, 10, 10, -10, -10, -10, -9, -9, -9,
				-9, -8, -8, -8, -7, -7, -7, -6, -6, -6, -6, -5, -5, -5, -4, -4, -4, -4 }, 10));
	}
}

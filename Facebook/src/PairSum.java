import java.util.HashMap;
import java.util.Objects;

public class PairSum {

	public static int numberOfWays1(int[] arr, int k) {
		// Write your code here
		if (Objects.isNull(arr) || arr.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> numberCount = new HashMap<>();
		for (int value : arr) {
			if (numberCount.containsKey(value)) {
				numberCount.put(value, numberCount.get(value) + 1);
			} else {
				numberCount.put(value, 1);
			}
		}

		int doubleCount = 0;

		for (int value : arr) {
			if (numberCount.containsKey(k - value))
				doubleCount += numberCount.get(value);

			if (k - value == value)
				--doubleCount;
		}
		return doubleCount / 2;
	}

	// o(n)2
	public static int numberOfWays(int[] arr, int k) {
		if (Objects.isNull(arr) || arr.length == 0)
			return 0;
		int count = 0;
		for (int x = 0; x < arr.length; x++) {
			for (int y = x + 1; y < arr.length; y++) {
				if (arr[x] + arr[y] == k) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(numberOfWaysOptimal(new int[] { 1, 5, 3, 3, 3 }, 6));
	}

	// O(n)
	private static int numberOfWaysOptimal(int[] arr, int sum) {
		if (Objects.isNull(arr) || arr.length == 0)
			return 0;
		HashMap<Integer, Integer> count = new HashMap<>();
		for (int num : arr) {
			if (count.containsKey(num)) {
				count.put(num, count.get(num) + 1);
			} else {
				count.put(num, 1);
			}
		}

		int doubleCount = 0;

		for (int num : arr) {
			if (!Objects.isNull(count.get(sum - num))) {
				doubleCount += count.get(sum - num);
			}

			if (sum - num == num)
				--doubleCount;
		}

		return doubleCount / 2;
	}
}

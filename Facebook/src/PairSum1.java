import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PairSum1 {

	public static int numberOfWays(int[] arr, int k) {
		if (Objects.isNull(arr) || arr.length == 0)
			return 0;

		Map<Integer, Integer> numberCount = new HashMap<>();

		for (int num : arr) {
			if (numberCount.containsKey(num)) {
				numberCount.put(num, numberCount.get(num) + 1);
			} else {
				numberCount.put(num, 1);
			}
		}

		int doubleCount = 0;

		for (int num : arr) {
			if (numberCount.containsKey(k - num)) {
				doubleCount += numberCount.get(k - num);
			}
			if (k - num == num)
				--doubleCount;
		}

		return doubleCount / 2;
	}
}

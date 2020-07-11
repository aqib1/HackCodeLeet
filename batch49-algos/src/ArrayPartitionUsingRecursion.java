import java.util.HashMap;
import java.util.stream.IntStream;

public class ArrayPartitionUsingRecursion {
	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 5, 5, 2, 11 }));
	}

	private static boolean canPartition(int[] is) {
		if (is == null || is.length <= 1)
			return false;
		int sum = IntStream.of(is).sum();
		if (sum % 2 != 0)
			return false;

		return canPartition(is, 0, 0, sum, new HashMap<>());
	}

	private static boolean canPartition(int[] is, int index, int currentSum, int sum, HashMap<String, Boolean> map) {
		String key = index + "," + currentSum;
		if (map.containsKey(key))
			return map.get(key);
		if (currentSum == sum / 2)
			return true;
		if (currentSum > sum / 2 || index >= is.length)
			return false;
		boolean result = canPartition(is, index + 1, currentSum, sum, map) ||

				canPartition(is, index + 1, currentSum + is[index], sum, map);
		map.put(key, result);
		return result;
	}
}

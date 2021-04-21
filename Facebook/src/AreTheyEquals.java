import java.util.HashMap;
import java.util.Map;

public class AreTheyEquals {

	public static boolean areTheyEqual(int[] array_a, int[] array_b) {
		if (array_a.length != array_b.length)
			return Boolean.FALSE;
		Map<Integer, Integer> countMap = new HashMap<>();

		for (int i = 0; i < array_a.length; i++) {
			updateMap(countMap, array_a[i], 1);
			updateMap(countMap, array_b[i], -1);
		}

		long result = countMap.values().stream().filter(value -> value != 0).findFirst().orElse(Integer.MIN_VALUE);
		return result == Integer.MIN_VALUE ? Boolean.TRUE : Boolean.FALSE;
	}

	private static void updateMap(Map<Integer, Integer> countMap, int key, int incr) {
		if (countMap.containsKey(key)) {
			countMap.put(key, countMap.get(key) + incr);
		} else {
			countMap.put(key, incr);
		}
	}

	public static void main(String[] args) {
		System.out.println(areTheyEqual(new int[] { 2, 2, 1 }, new int[] { 1, 2, 1 }));
	}
}

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pair_Sum {

	private static int numberOfWays(int[] arr, int k) {
		if(Objects.isNull(arr) || arr.length == 0)
			return 0;
		Map<Integer, Long> countNumber = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int doubleCount = 0;
		for (int value : arr) {
			if (countNumber.containsKey(k - value))
				doubleCount += countNumber.get(k - value);
			if (k - value == value)
				--doubleCount;
		}
		return doubleCount / 2;
	}

	public static void main(String[] args) {
		System.out.println(numberOfWays(new int[] { 1, 5, 3, 3, 3 }, 6));
	}
}

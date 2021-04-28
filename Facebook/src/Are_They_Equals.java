import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Are_They_Equals {
	public static boolean areTheyEqual(int[] arr_a, int[] arr_b) {
		if (Objects.isNull(arr_a) || Objects.isNull(arr_b))
			return Boolean.FALSE;

		Map<Integer, Long> mapCount = Arrays.stream(arr_a).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		for (int x = 0; x < arr_b.length; x++) {
			long value = mapCount.getOrDefault(arr_b[x], 0L);
			mapCount.put(arr_b[x], value - 1);
		}
		long value = mapCount.values().stream().filter(val -> val != 0L).findAny().orElse(-2L);
		return (value != -2L) ? Boolean.FALSE : Boolean.TRUE;
	}
	
	public static void main(String[] args) {
		System.out.println(areTheyEqual(new int[]  {1, 2, 3, 4}, new int[]  {1, 4, 3, 3}));
	}
}

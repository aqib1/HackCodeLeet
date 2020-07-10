import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatedNumber {

	public static void main(String[] args) {
		System.out.println(getRepeatedNumber(new int[] { 1, 2, 3, 3, 4, 1, 2, 5 }));
	}

	public static List<Integer> getRepeatedNumber(int[] arr) {
		HashMap<Integer, Integer> numberToCount = new HashMap<>();
		for (int a : arr) {
			if (numberToCount.containsKey(a))
				numberToCount.put(a, numberToCount.get(a) + 1);
			else
				numberToCount.put(a, 1);
		}
		return numberToCount.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey())
				.collect(Collectors.toList());
	}
}

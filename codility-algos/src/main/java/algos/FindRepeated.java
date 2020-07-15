package algos;

import java.util.HashSet;
import java.util.Set;

public class FindRepeated {

	public static int findRepeated(int[] repeated) {
		if (repeated == null || repeated.length == 0)
			return -1;
		Set<Integer> set = new HashSet<>();
		for (int value : repeated) {
			if (set.contains(value))
				return value;
			set.add(value);
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findRepeated(new int[] { 2, 3, 1, 2, 1 }));
	}

}

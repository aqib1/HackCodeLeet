package generalbasicalgos;

import java.util.Arrays;
import java.util.Objects;

public class StringsAnagramAlgo {

	private int[] chars = new int[256];

	// Time complexity O(n) + O(n) = O(2n) which is O(n)
	// Space complexity is O(1) as we have fixed size of chars array, 256 characters 
	public boolean arePermutation(String s1, String s2) {
		if (Objects.isNull(s1) || Objects.isNull(s2) || s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) {
			return false;
		}
		int limit = s1.length();
		for (int x = 0; x < limit; x++) {
			chars[s1.charAt(x)]++;
			chars[s2.charAt(x)]++;
		}
		long count = Arrays.stream(chars).filter(x -> x == 2).count();
		return count == limit;
	}
}

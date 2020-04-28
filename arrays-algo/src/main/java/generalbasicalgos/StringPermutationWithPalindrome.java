package generalbasicalgos;

import java.util.Arrays;
import java.util.Objects;

public class StringPermutationWithPalindrome {

	//Time complexity O(n) + O(n) = O(2n) -> O(n)
	// Space complexity is O(1) as we are using fixed size of chars array
	public boolean canAnagramPalindrome(String s) {
		if (Objects.isNull(s) || s.isEmpty())
			return false;
		if (s.length() == 1)
			return true;
		int chars[] = new int[256];
		for (char c : s.toCharArray()) {
			chars[c]++;
		}
		return Arrays.stream(chars).filter(x -> x % 2 != 0).count() <= 1;
	}
}

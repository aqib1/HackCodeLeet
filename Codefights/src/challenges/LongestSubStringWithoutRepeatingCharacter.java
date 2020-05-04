package challenges;

import java.util.Objects;

public class LongestSubStringWithoutRepeatingCharacter {

	// using sliding window approach

	public int lengthOfLongestSubstring(String value) {
		if (Objects.isNull(value) || value.isEmpty())
			return 0;
		int max_len = Integer.MIN_VALUE;
		int[] chars = new int[256];
		int i = 0, j = 0, n = value.length();

		while (i < n && j < n) {
			if (chars[value.charAt(i)] < 1) {
				chars[value.charAt(i++)]++;
				max_len = Math.max(max_len, i - j);
			} else {
				chars[value.charAt(j++)]--;
			}
		}

		return max_len;
	}

}

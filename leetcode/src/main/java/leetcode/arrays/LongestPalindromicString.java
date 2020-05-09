package leetcode.arrays;

import java.util.Objects;

public class LongestPalindromicString {
	public String longestPalindrome(String s) {
		if (Objects.isNull(s) || s.isEmpty())
			return "";
		if (s.length() == 1)
			return s;
		int max_val = Integer.MIN_VALUE;
		String result = "";
		for (int x = 0; x < s.length(); x++) {
			for (int y = (x + 1); y <= s.length(); y++) {
				String val = s.substring(x, y);
				if (val.equals(new StringBuilder(val).reverse().toString())) {
					if (max_val < val.length()) {
						max_val = val.length();
						result = val;
						continue;
					}
				}
			}
		}

		return result;
	}
}

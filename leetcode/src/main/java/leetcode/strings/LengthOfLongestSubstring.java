package leetcode.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LengthOfLongestSubstring {

	// Brute force O(n)3 time and space O(k) where k is the number of string in List 
	public List<String> uniqueSubString(String value) {
		if(Objects.isNull(value) || value.isEmpty())
			return new ArrayList<>();
		List<String> uniqueSubstrings = new ArrayList<>();
		String subStr = "";
		for (int x = 0; x < value.length(); x++) {
			subStr = Character.toString(value.charAt(x));
			for (int y = x + 1; y < value.length(); y++) {
				if (!subStr.contains(String.valueOf(value.charAt(y))))
					subStr += value.charAt(y);
				else break;
			}
			uniqueSubstrings.add(subStr);
		}
		return uniqueSubstrings;
	}

	public int lengthOfLongestSubstring(String s) {
		if(Objects.isNull(s))
			return 0;
		if (s.length() <= 1)
			return s.length();
		return uniqueSubString(s).stream().mapToInt(m -> m.length()).max().orElse(-1);
	}

}

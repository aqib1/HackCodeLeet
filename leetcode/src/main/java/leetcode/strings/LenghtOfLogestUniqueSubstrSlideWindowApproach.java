package leetcode.strings;

import java.util.Objects;

public class LenghtOfLogestUniqueSubstrSlideWindowApproach {

	/*
	 * value -> aabc uniqueSubString(value)
	 * 
	 * - brute-force approach -> all possible subStrigs (unique one's) -> and return
	 * the longest substring length O(n)3 with O(n) time complexity - Sliding window
	 * Approach -> use two pointer like (i, j) == 0 which point two character's of
	 * string (like a window) -> if character is unique then we will expand window
	 * from and end else we reduce window from start -> each time when we have
	 * unique character we cached max length so far -> Time complexity O(n) and
	 * space complexity O(1) if we use fixed character array, and if we use set then
	 * O(n)
	 */
	public int uniqueSubString(String value) {
		if (Objects.isNull(value) || value.isEmpty())
			return 0;
		if (value.length() == 1)
			return 1;
		final int[] charCount = new int[123];
		int x = 0, y = 0, n = value.length(), max = Integer.MIN_VALUE;
		while (x < n && y < n) {
			if (charCount[value.charAt(x)] < 1) {
				charCount[value.charAt(x++)]++;
				max = Math.max(max, x-y);
			} else {
				charCount[value.charAt(y++)]--;
			}
		}
		return max;
	}
}

package algorithm;

public class LongestSubStringWithoutRepeatingCharacter {
	// abcabcbb
	// Time complexity is O(n) and space is O(256)
	public int lengthOfLongestSubstring(String s) {
		int[] charCounts = new int[256];
		int i = 0, j = 0, max_value = 0;
		while (i < s.length() && j < s.length()) {
			if (charCounts[s.charAt(j)] < 1) {
				charCounts[s.charAt(j++)]++;
				max_value = Math.max(max_value, j - i);
			} else {
				charCounts[s.charAt(i++)]--;
			}
		}
		return max_value;
	}

	public static void main(String[] args) {

	}

}

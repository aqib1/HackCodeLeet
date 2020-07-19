package algorithm;

public class LongestSubStringWithKRepeatedCharacters {
	public static void main(String[] args) {
		System.out.println(longestSubstring("ababbc", 2));
	}

	public static int longestSubstring(String s, int k) {
		int[] characters = new int[256];
		int i = 0, j = 0;
		int max = Integer.MIN_VALUE;
		while (i < s.length() && j < s.length()) {
			if (characters[s.charAt(j)] < k) {
				characters[s.charAt(j++)]++;
			} else {
				max = Math.max(max, j - i);
				characters[s.charAt(i++)]--;
			}
		}

		return max;
	}
}

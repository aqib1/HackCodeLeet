import java.util.Objects;

public class LongestSubStringWIthoutRepeating {

	// O(N)
	public static int lengthOfLongestSubstring(String s) {
		if (Objects.isNull(s) || s.isEmpty())
			return 0;

		int[] count = new int[256];
		int i = 0, j = 0;
		int len = Integer.MIN_VALUE;

		while (i < s.length() && j < s.length()) {
			if (count[s.charAt(j)] < 1) {
				count[s.charAt(j++)]++;
				len = Math.max(len, j - i);
			} else {
				count[s.charAt(i++)]--;
			}
		}

		return len;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}

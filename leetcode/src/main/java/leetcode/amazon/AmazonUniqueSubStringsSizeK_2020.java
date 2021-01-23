package leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonUniqueSubStringsSizeK_2020 {

	/**
	 * Given a string s and an int k, return all unique substrings of s of size k
	 * with k distinct characters.
	 * 
	 * Example 1:
	 * 
	 * Input: s = "abcabc", k = 3 Output: ["abc", "bca", "cab"] Example 2:
	 * 
	 * Input: s = "abbacab", k = 3 Output: ["bac", "cab"] Example 3:
	 * 
	 * Input: s = "awaglknagawunagwkwagl", k = 4 Output: ["wagl", "aglk", "glkn",
	 * "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
	 * Explanation: Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag",
	 * "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" "wagl" is
	 * repeated twice, but is included in the output once. Constraints:
	 * 
	 * The input string consists of only lowercase English letters [a-z] 0 ≤ k ≤ 26
	 */
	public static void main(String[] args) {
		System.out.println(uniqueSubstringSizeK("awaglknagawunagwkwagl", 4));
	}

	// Time complexity O(n*26) = O(n) and space is O(n + 26) = O(n)
	public static List<String> uniqueSubstringSizeK(String s, int k) {
		if (k == 0 || s.isEmpty()) {
			return new ArrayList<>();
		}
		int[] charCounter = new int[26];
		int i = 0, j = 0, uniquecount = 0;
		List<String> result = new ArrayList<>();
		while (i < s.length() && j < s.length()) {
			int count = ++charCounter[s.charAt(j++) - 'a'];
			uniquecount++;
			if (count > 1) {
				charCounter[s.charAt(i++) - 'a']--;
				uniquecount--;
			}
			if (uniquecount == k) {
				result.add(s.substring(i++, j));
				uniquecount = 0;
				Arrays.fill(charCounter, 0);
				j = i;
			}

		}

		return result;
	}
}

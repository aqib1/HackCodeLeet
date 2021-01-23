import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

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
 * The input string consists of only lowercase English letters [a-z] 26 Input: s
 * = "abcabc", k = 3 Output: ["abc", "bca", "cab"] Example 2:
 */
public class UniqueSubStringWithKNumbers {
	// O(n) * O(26) = O(n)
	public static Set<String> subStrings(String data, int k) {
		int[] count = new int[26];
		int i = 0, j = 0;
		Set<String> set = new LinkedHashSet<>();
		while (i < data.length() && j < data.length()) {
			if (count[data.charAt(j) - 'a'] >= 1) {
				count[data.charAt(i++) - 'a']--;
			} else {
				if (j - i == k - 1 && j < data.length()) {
					set.add(data.substring(i, j + 1));
					Arrays.fill(count, 0);
					j = ++i;
				}
				count[data.charAt(j++) - 'a']++;
			}

		}
		return set;
	}

	public static void main(String[] args) {
		System.out.println(subStrings("awaglknagawunagwkwagl", 4));
	}

}

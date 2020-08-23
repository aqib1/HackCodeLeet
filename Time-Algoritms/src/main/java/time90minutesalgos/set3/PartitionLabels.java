package time90minutesalgos.set3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Input: S = "ababcbacadefegdehijhklij" Output: [9,7,8] Explanation: The
 * partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that
 * each letter appears in at most one part. A partition like "ababcbacadefegde",
 * "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {

	// Time complexity is O(n) and space is O(26)
	public static List<Integer> partitionLabels(String S) {
		int[] lastIndexes = new int[26]; // for characters a-z
		List<Integer> result = new ArrayList<>();
		for (int x = 0; x < S.length(); x++)
			lastIndexes[S.charAt(x) - 'a'] = x;
		int start = 0, last = 0;
		for (int x = 0; x < S.length(); x++) {
			last = Math.max(lastIndexes[S.charAt(x) - 'a'], last);
			if (x == last) {
				result.add((last - start) + 1);
				start = last = x + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(partitionLabels("ceaaaabaae"));
	}
}

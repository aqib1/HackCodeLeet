package algorithm;

public class CountSubstring {
	public int countSubstrings(String s) {
		int count = 0;
		boolean brb[][] = new boolean[s.length()][s.length()];

		// for 1 element
		for (int x = 0; x < s.length(); x++) {
			brb[x][x] = true;
			count++;
		}

		// for 2 elements
		for (int x = 0; x < s.length() - 1; x++) {
			if (s.charAt(x) == s.charAt(x + 1)) {
				brb[x][x + 1] = true;
				count++;
			}
		}

		// for more than 2

		int j;

		for (int k = 2; k < s.length(); k++) {
			for (int i = 0; i < s.length() - k; i++) {
				j = i + k;
				if (s.charAt(i) == s.charAt(j) && brb[i + 1][j - 1]) {
					brb[i][j] = true;
					count++;
				}
			}
		}

		return count;

	}
}

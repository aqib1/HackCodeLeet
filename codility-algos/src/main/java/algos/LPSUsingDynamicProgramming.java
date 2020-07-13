package algos;

public class LPSUsingDynamicProgramming {

	public String lpsUsingDynamicProgramming(String string) {
		if (string == null || string.isEmpty())
			return "";
		String lps = "";
		int len = string.length();
		boolean[][] backtrack = new boolean[len][len];
		int max_len = Integer.MIN_VALUE;

		// for one character bactracking
		for (int x = 0; x < len; x++) {
			backtrack[x][x] = true;
			String sbstr = string.substring(x, x + 1);
			if (max_len < sbstr.length()) {
				max_len = sbstr.length();
				lps = sbstr;
			}

		}

		// for two character backtracking
		for (int x = 0; x < len - 1; x++) {
			if (string.charAt(x) == string.charAt(x + 1)) {
				backtrack[x][x + 1] = true;
				String sbstr = string.substring(x, x + 2);
				if (max_len < sbstr.length()) {
					max_len = sbstr.length();
					lps = sbstr;
				}
			}
		}

		// for more than two characters
		int j;
		for (int k = 2; k < len; k++) {
			for (int i = 0; i < len - k; i++) {
				j = i + k;
				if (string.charAt(i) == string.charAt(j) && backtrack[i + 1][j - 1]) {
					backtrack[i][j] = true;
					String substr = string.substring(i, j + 1);
					if (max_len < substr.length()) {
						max_len = substr.length();
						lps = substr;
					}
				}
			}
		}

		return lps;

	}
}

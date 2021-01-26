
public class LongestPalindromicSubstring {

	// O(2K + N2) -> O(n)2
	public static String longestPalindromicStringDP(String s) {
		String lps = "";

		int len = s.length();
		boolean[][] backtrack = new boolean[len][len];

		// for 1 character
		for (int x = 0; x < len; x++) {
			backtrack[x][x] = true;
			lps = s.substring(x, x + 1);
		}

		// for 2 characters
		for (int x = 0; x < len - 1; x++) {
			if (s.charAt(x) == s.charAt(x + 1)) {
				backtrack[x][x + 1] = true;
				lps = s.substring(x, x + 2);
			}
		}

		// for more than 2 characters
		int j;
		for (int x = 2; x < len; x++) {
			for (int i = 0; i < len - x; i++) {
				j = i + x;
				if (s.charAt(i) == s.charAt(j) && backtrack[i + 1][j - 1]) {
					backtrack[i][j] = true;
					String sub = s.substring(i, j + 1);
					if (lps.length() < sub.length()) {
						lps = sub;
					}
				}
			}
		}

		return lps;
	}

	// O(n3) => Bad
	public static String longestPalindromeBad(String s) {
		String rs = "";

		// O(n2)
		for (int row = 0; row < s.length(); row++) {
			for (int col = row + 1; col < s.length() + 1; col++) {
				String sub = s.substring(row, col);
				if (isPalindrome(sub)) {
					if (rs.length() < sub.length()) {
						rs = sub;
					}
				}
			}
		}

		return rs;
	}

	public static boolean isPalindrome(String s) {
		return s.equals(new StringBuilder(s).reverse().toString()); // O(n)
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromicStringDP("cbbd"));
	}
}

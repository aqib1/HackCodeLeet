
public class LCS {

	public static int lcs(String a, String b) {

		char aChars[] = a.toCharArray();
		char bChars[] = b.toCharArray();

		return lcs(aChars, bChars, a.length(), b.length());
	}

	private static int lcs(char[] aChars, char[] bChars, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
		for (int ia = 0; ia <= m; ia++) {
			for (int ib = 0; ib <= n; ib++) {
				if (ia == 0 || ib == 0)
					dp[ia][ib] = 0;
				else if (aChars[ia - 1] == bChars[ib - 1])
					dp[ia][ib] = dp[ia - 1][ib - 1] + 1;
				else
					dp[ia][ib] = Math.max(dp[ia - 1][ib], dp[ia][ib - 1]);
			}

		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		System.out.println(lcs("GXTXAYB", "AGGTAB"));
	}
}

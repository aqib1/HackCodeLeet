
public class MinimumInsertionToFormPalindrome {
	// longest common sequence
	public static int LCS(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int x = 0; x <= m; x++) {
			for (int y = 0; y <= n; y++) {
				if (x == 0 || y == 0)
					dp[x][y] = 0;
				else if (a.charAt(x - 1) == b.charAt(y - 1)) {
					dp[x][y] = dp[x - 1][y - 1] + 1;
				} else
					dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);
			}
		}

		return dp[m][n];
	}

	public static int findMinInsertionsDP(String value) {
		return value.length() - LCS(value, new StringBuilder(value).reverse().toString());
	}
	
	public static void main(String[] args) {
		System.out.println(findMinInsertionsDP("abc"));
	}
}

package revision;

import java.util.Objects;

public class StringLargestPalindrom {

	public static String palindromFast(String val) {
		if (Objects.isNull(val) || val.isBlank())
			return null;
		String max = "";
		int limit = val.length();
		boolean[][] backtrack = new boolean[limit][limit];
		// solve for single char
		for (int x = 0; x < limit; x++) {
			backtrack[x][x] = true;
			max = val.substring(x, x + 1);
		}

		// solve for two chars
		for (int x = 0; x < limit - 1; x++) {
			if (val.charAt(x) == val.charAt(x + 1)) {
				backtrack[x][x + 1] = true;
				max = val.substring(x, x + 2);
			}
		}

		// solve for more than two
		int j;
		for (int k = 2; k < limit; k++) {
			for (int i = 0; i < limit - k; i++) {
				j = i + k;
				if (val.charAt(i) == val.charAt(j) && backtrack[i + 1][j - 1]) {
					backtrack[i][j] = true;
					String sub = val.substring(i, j + 1);
					if (max.length() < sub.length())
						max = sub;
				}
			}
		}
		return max;
	}

	// Time complexity is O(n2) and then for reverse again O(n)
	// O(n3) not good
	public static String palindrom(String val) {
		if (Objects.isNull(val) || val.isBlank())
			return null;
		String max = "";
		for (int x = 0; x < val.length(); x++) {
			for (int y = x + 1; y <= val.length(); y++) {
				String sub = val.substring(x, y);
				if (isPalindrom(sub))
					if (max.length() < sub.length())
						max = sub;
			}
		}

		return max;
	}

	public static boolean isPalindrom(String val) {
		return val.equals(new StringBuilder(val).reverse().toString());
	}

	public static void main(String[] args) {
		System.out.println(palindromFast("abcba"));
	}
}

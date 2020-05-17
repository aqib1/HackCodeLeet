package leetcode.arrays;

import java.util.Objects;

public class LongestPalindromeDynamicProg {
	
	public  String longestPalindrome(String s) {
		if (Objects.isNull(s) || s.isEmpty())
			return "";
		// boolean table for dynamic problem solving
		int min_len = Integer.MIN_VALUE;
		String palindrome = "";
		int m = s.length();
		boolean[][] strbrd = new boolean[m][m];

		// for single character
		for (int x = 0; x < m; x++) {
			strbrd[x][x] = true;
			String subStr = s.substring(x, x + 1);
			if (min_len < subStr.length()) {
				min_len = subStr.length();
				palindrome = subStr;
			}
		}

		// for 2 characters
		for (int x = 0; x < m - 1; x++) {
			if (s.charAt(x) == s.charAt(x + 1)) {
				strbrd[x][x + 1] = true;
				String subStr = s.substring(x, x + 2);
				if (min_len < subStr.length()) {
					min_len = subStr.length();
					palindrome = subStr;
				}
			}
		}

		// for more than 2 characters
		int j;
		for (int k = 2; k < m - 2; k++) {
			for (int i = 0; i < m - k; i++) {
				j = i + k;
				if(s.charAt(i) == s.charAt(j) && strbrd[i+1][j-1]) {
					strbrd[i][j] = true;
					String subStr = s.substring(i, j + 1);
					if (min_len < subStr.length()) {
						min_len = subStr.length();
						palindrome = subStr;
					}
				}
			}
		}

		return palindrome;
	}
}

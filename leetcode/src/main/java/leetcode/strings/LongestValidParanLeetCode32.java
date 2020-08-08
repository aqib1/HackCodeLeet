package leetcode.strings;

import java.util.Stack;

public class LongestValidParanLeetCode32 {

	// Time complexity is O(n) and space complexity is O(n)
	public static int longestValidParentheses(String s) {
		int maxValid = 0;
		int sum = 0;
		int[] track = new int[s.length()];
		Stack<Integer> paranIndexes = new Stack<>();
		for (int x = 0; x < s.length(); x++) {
			if (s.charAt(x) == '(') {
				paranIndexes.push(x);
			} else {
				if (!paranIndexes.isEmpty()) {
					track[x] = 1;
					track[paranIndexes.pop()] = 1;
				}
			}
		}
		for (int x = 0; x < track.length; x++) {
			if (track[x] == 0)
				sum = 0;
			else {
				sum += track[x];
				maxValid = Math.max(maxValid, sum);
			}
		}
		return maxValid;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(())(()()()()"));
	}
}

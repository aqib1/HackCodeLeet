package leetcode.strings;

import java.util.Stack;

public class LongestValidParanLeetCode32_InvalidMarginApproach {
	// Time complexity is O(n) and space complexity is O(n)
	public static int longestValidParentheses(String s) {
		int maxlen = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		for (int index = 0; index < s.length(); index++) {
			if (s.charAt(index) == '(') {
				stack.push(index);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(index);
				} else {
					maxlen = Math.max(maxlen, index - stack.peek());
				}
			}
		}

		return maxlen;
	}
}

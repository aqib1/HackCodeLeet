package leetcode.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParan {
	public boolean isValid(String s) {
		Map<Character, Character> bracketMap = new HashMap<>();
		bracketMap.put(')', '(');
		bracketMap.put('}', '{');
		bracketMap.put(']', '[');
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (bracketMap.get(c) != stack.pop()) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}

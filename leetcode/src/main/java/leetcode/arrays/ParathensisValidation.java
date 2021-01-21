package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ParathensisValidation {
	public static boolean isValid(String paran) {
		Stack<Character> stack = new Stack<>();
		Set<Character> opening = new HashSet<>(Arrays.asList('{', '(', '['));
		Map<Character, Character> closingRule = Map.of('}', '{', ')', '(', ']', '[');
		for (int x = 0; x < paran.length(); x++) {
			char current = paran.charAt(x);
				if(opening.contains(current)) {
					stack.push(current);
				} else if(stack.isEmpty() || stack.pop() != closingRule.get(current)) {
						return false;
					}
		}
		return stack.isEmpty();
	}
}

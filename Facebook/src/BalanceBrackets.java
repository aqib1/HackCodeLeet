import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class BalanceBrackets {
	public static boolean isBalanced(String s) {
		if (Objects.isNull(s) || s.isEmpty())
			return Boolean.FALSE;
		HashMap<Character, Character> pairsBrackets = new HashMap<>();
		pairsBrackets.put(')', '(');
		pairsBrackets.put('}', '{');
		pairsBrackets.put(']', '[');

		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (pairsBrackets.keySet().contains(c)) {
				if (stack.isEmpty() || stack.pop() != pairsBrackets.get(c))
					return Boolean.FALSE;
			} else
				stack.push(c);
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isBalanced("(("));
	}
}

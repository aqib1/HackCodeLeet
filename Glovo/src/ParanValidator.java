import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class ParanValidator {

	public static boolean paranValid(String value) {
		if (Objects.isNull(value) || value.isBlank()) {
			return false;
		}
		Set<Character> opening = new HashSet<>(Arrays.asList('{', '[', '('));
		Map<Character, Character> pairs = Map.of('}', '{', ')', '(', '[', ']');
		Stack<Character> stack = new Stack<>();

		for (char x : value.toCharArray()) {
			if (opening.contains(x))
				stack.push(x);
			else {
				if (stack.isEmpty() || stack.pop() != pairs.get(x))
					return false;
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(paranValid(")))"));
	}
}

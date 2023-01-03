import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        // O(3) space
        Map<Character, Character> validPairs = new HashMap<>();
        validPairs.put('(', ')');
        validPairs.put('{', '}');
        validPairs.put('[', ']');
        // O(3) space
        Collection<Character> openingParen = validPairs.keySet();

        // O(N) space in worst case
        Stack<Character> stack = new Stack<>();
        for(char paren : s.toCharArray()) {
            if(openingParen.contains(paren)) {
                stack.add(paren);
            } else if(stack.isEmpty() || paren != validPairs.get(stack.pop())) {
                    return false;
                }

        }
        return stack.isEmpty();
    }
}

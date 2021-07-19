import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class LiveCode {
	private static final boolean VALID_PARAN = true;
	private static final boolean INVALID_PARAN = false;
	// [()]
	 public static boolean haValidParanthesis(String input) {
		 if(input.isBlank()) {
			 return VALID_PARAN;
		 }
		 Map<Character, Character> paranPair = Map.of(')','(',']', '[','}', '{');
	     Stack<Character> validator = new Stack<>();
	     // ( [ {
	     // O(1)
	     Set<Character> startingParan = paranPair
	    		 .values()
	    		 .stream()
	    		 .collect(Collectors.toSet());
	     
	     for(char current : input.toCharArray()) {
	    	 if(startingParan.contains(current)) {
	    		 validator.push(current);
	    	 } else {
	    		 if(validator.isEmpty() || 
	    				 !paranPair.containsKey(current) || 
	    				 		paranPair.get(current) != validator.pop()) {
	    			return INVALID_PARAN; 
	    		 }
	    	 }
	     }
	     
		 return validator.isEmpty();
	   }
	 
	 public static void main(String[] args) {
		System.out.println(haValidParanthesis("()"));
		System.out.println(haValidParanthesis("([)"));
		System.out.println(haValidParanthesis("([])"));
		System.out.println(haValidParanthesis("(){}"));
		System.out.println(haValidParanthesis("(("));
	}
}

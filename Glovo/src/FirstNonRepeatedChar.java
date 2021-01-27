import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {

	// Time complexity O(n) and space O(2n) -> O(n)
	public static Character firstNonRepeatedWithSinglePass(String val) {
		Set<Character> repeating = new HashSet<>();
		Set<Character> nonRepeating = new LinkedHashSet<>();
		for(char c: val.toCharArray()) {
			if(repeating.contains(c)) {
				continue;
			} else {
				if(nonRepeating.contains(c)) {
					nonRepeating.remove(c);
					repeating.add(c);
				} else {
					nonRepeating.add(c);
				}
			}
		}
		return nonRepeating.isEmpty() ? null : nonRepeating.iterator().next();
	}
	
	// Time complexity O(2n) -> O(n)
	// Space O(n)
	public static Character firstNonRepeated(String val) {
		if (Objects.isNull(val) || val.isBlank())
			return null;
		Map<Character, Long> strToCount = val.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for (char c : val.toCharArray())
			if (strToCount.get(c) == 1)
				return c;
		return null;
	}

	public static void main(String[] args) {
		System.out.println(firstNonRepeatedWithSinglePass("cadassaddaccffe"));
	}
}

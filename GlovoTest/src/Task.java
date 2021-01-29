import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task {

	/**
	 * ----------------- Input: ABCD, DABC Output: true
	 * 
	 * Input: AABB, BBAA Output: true
	 * 
	 * Input: AAAB, AAB Output: false
	 * 
	 * Input: AAAB, AABC Output: false
	 * 
	 * AABC DDBC
	 */
//	class N
	public static boolean anagram(String a1, String a2) {
		if (Objects.isNull(a1) || Objects.isNull(a2))
			return false;
		if (a1.isEmpty() && a2.isEmpty())
			return true;
		if (a1.length() != a2.length()) {
			return false;
		}
		char[] countA1 = new char[256];
		char[] countA2 = new char[256];
		for (int x = 0; x < a1.length(); x++) {
			countA1[a1.charAt(x)]++;
			countA2[a2.charAt(x)]++;
		}
		for (int x = 0; x < a1.length(); x++) {
			if (countA1[a1.charAt(x)] != countA2[a1.charAt(x)])
				return false;
		}
		return true;
	}

	
	public static void main(String[] args) {
		System.out.println(anagram("AAAB", "AAB"));

	}
	
	public static Character findFirstRecurrent(String str) {
		if (Objects.isNull(str) || str.isEmpty()) {
			return null;
		}
		Map<Character, Long> charByCount = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		for (char c : str.toCharArray()) {
			if (charByCount.get(c) > 1)
				return c;
		}

		return null;
	}

	
}

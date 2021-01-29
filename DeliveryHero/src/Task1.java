import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class Task1 {

	public int solution(String s) {
		if (Objects.isNull(s) || s.isEmpty()) {
			return 0;
		}
		int deathCount = 0;
		Map<Character, List<Character>> rules = Map.of('A', Arrays.asList('B', 'C'), 'B', Arrays.asList('C', 'D'), 'C',
				Arrays.asList('D'), 'D', Arrays.asList());
		Map<Character, Integer> charToCount = new HashMap<>();
		Queue<Character> q = new LinkedList<>();
		for (char c : s.toCharArray()) {

		}
		for (int x = 0; x < s.length(); x++) {
			char cc = s.charAt(x);
			if(charToCount.containsKey(cc)) {
				charToCount.put(cc, charToCount.get(cc)+1);
			} else charToCount.put(cc, 1);
		}

		return 0;
	}
}

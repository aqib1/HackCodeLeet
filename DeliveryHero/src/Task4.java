import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Task4 {

	public static int fishEating(String fishes) {
		if (Objects.isNull(fishes) || fishes.isEmpty())
			return 0;
		Map<Character, List<Character>> rules = new HashMap<>();
		rules.put('A', Arrays.asList('B', 'C'));
		rules.put('B', Arrays.asList('C', 'D'));
		rules.put('C', Arrays.asList('D'));
		rules.put('D', Arrays.asList());
		char fishArr[] = fishes.toCharArray();
		ArrayDeque<Character> deque = new ArrayDeque<>();
		for (char c : fishArr) {
			deque.add(c);
		}
		int count = 1;
		while (deque.size() > 1) {
			if (count > (deque.size() / 2) + 2)
				break;
			char first = deque.removeFirst();
			char second = deque.removeFirst();
			if (first != second && rules.get(first).contains(second)) {
				deque.addLast(first);
			} else {
				deque.addLast(first);
				deque.addLast(second);
				count++;
			}
		}
		return deque.size();
	}

	public static void main(String[] args) {
		System.out.println(fishEating("ACCD"));
	}
}

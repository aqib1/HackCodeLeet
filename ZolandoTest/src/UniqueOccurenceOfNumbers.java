import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniqueOccurenceOfNumbers {

	public static int solution(String s) {
		if (Objects.isNull(s) || s.length() == 0) {
			return 0;
		}
		int count = 0;

		Map<Character, Integer> charToCount = new HashMap<>();
		for (int x = 0; x < s.length(); x++) {
			if (charToCount.containsKey(s.charAt(x))) {
				charToCount.put(s.charAt(x), (charToCount.get(s.charAt(x)) + 1));
			} else {
				charToCount.put(s.charAt(x), 1);
			}
		}
		Queue<Integer> max_heap = new PriorityQueue<>(charToCount.size(), Collections.reverseOrder());
		max_heap.addAll(charToCount.values());
		while (!max_heap.isEmpty() && max_heap.peek() != 0) {
			int current = max_heap.poll();
			if(max_heap.isEmpty())
				break;
			if (current == max_heap.peek()) {
				count++;
				max_heap.add(current - 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
			System.out.println(solution("aaaabbbb"));
			System.out.println(solution("ccaaffddecee"));
			System.out.println(solution("eeee"));
			System.out.println(solution("example"));
	}
}

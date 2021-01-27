import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueOccurenceOfNumbers {

	public static int solution(String s) {
		if (Objects.isNull(s) || s.length() == 0) {
			return 0;
		}
		int count = 0;
		Map<String, Long> charToCount =
		s.chars().mapToObj(Character::toString)
		.collect(Collectors.groupingBy(Function.identity() ,Collectors.counting()));
		
		Queue<Long> max_heap = new PriorityQueue<>(charToCount.size(), Collections.reverseOrder());
		max_heap.addAll(charToCount.values());
		while (!max_heap.isEmpty() && max_heap.peek() != 0) {
			Long current = max_heap.poll();
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

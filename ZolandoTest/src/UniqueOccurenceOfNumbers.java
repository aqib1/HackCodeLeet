import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueOccurenceOfNumbers {
	
	 public static int solution2(String S) {
	        if (Objects.isNull(S) || S.length() == 0) {
	            return 0;
	        }

	        int deleteCount = 0;
	        Map<Character, Integer> countByCharacter = new HashMap<>();
	        for (int i = 0; i < S.length(); i++) {
	            Character c = S.charAt(i);
	            if (countByCharacter.containsKey(S.charAt(i))) {
	                countByCharacter.put(c, countByCharacter.get(c) + 1);
	            } else {
	                countByCharacter.put(c, 1);
	            }
	        }

	        Queue<Integer> reversePriority = new PriorityQueue<>(countByCharacter.size(), Collections.reverseOrder());
	        reversePriority.addAll(countByCharacter.values());
	        while (reversePriority.size() > 1 && reversePriority.peek() != 0) {
	            int current = reversePriority.poll();
	            if (current == reversePriority.peek()) {
	                deleteCount++;
	                reversePriority.add(current - 1);
	            }
	        }
	        return deleteCount;
	    }

	public static int solution(String s) {
		if (Objects.isNull(s) || s.isEmpty()) {
			return 0;
		}
		int count = 0;
		Map<String, Long> charToCount = s.chars().mapToObj(Character::toString)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Queue<Long> max_heap = new PriorityQueue<>(charToCount.size(), Collections.reverseOrder());
		max_heap.addAll(charToCount.values());
		while (!max_heap.isEmpty() && max_heap.peek() != 0) {
			Long current = max_heap.poll();
			if (max_heap.isEmpty())
				break;
			if (current == max_heap.peek()) {
				count++;
				max_heap.add(current - 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution2("abbcc1122"));
		System.out.println(solution("abb"));
		System.out.println(solution("eeee"));
		System.out.println(solution("example"));
	}
}

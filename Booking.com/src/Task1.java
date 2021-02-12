import java.util.ArrayDeque;
import java.util.Objects;
import java.util.stream.Collectors;

//String shift
public class Task1 {

	public static String getShiftedString(String str, int leftShift, int rightShift) {
		if (Objects.isNull(str) || leftShift < 0 || rightShift < 0) {
			return null;
		}
		ArrayDeque<Character> deque = new ArrayDeque<>();
		str.chars().forEach(x -> deque.add(Character.valueOf((char) x)));
		for (int x = 0; x < leftShift; x++) {
			char first = deque.removeFirst();
			deque.addLast(first);
		}
		for(int x=0; x < rightShift; x++) {
			char last = deque.removeLast();
			deque.addFirst(last);
		}
		return deque.stream().map(x -> String.valueOf(x)).collect(Collectors.joining());
	}

	public static void main(String[] args) {
		System.out.println(getShiftedString("abcdefg", 2, 4));
	}
}

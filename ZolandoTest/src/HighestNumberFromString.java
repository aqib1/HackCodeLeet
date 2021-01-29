import java.util.Objects;
import java.util.stream.IntStream;

public class HighestNumberFromString {

	public static int solution(String number) {
		if (Objects.isNull(number) || number.isEmpty()) {
			return 0;
		}
		if (number.length() <= 2)
			return Integer.parseInt(number);

		return IntStream.range(0, number.length() - 1)
					.map(val -> Integer.valueOf(number.substring(val, val + 2)))
					.max()
					.getAsInt();
	}

	public static void main(String[] args) {
//		System.out.println("".compareTo("60"));
		System.out.println(solution("50559"));
		System.out.println(solution("10101"));
		System.out.println(solution("988"));
	}
}

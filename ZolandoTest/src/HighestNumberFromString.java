import java.util.Objects;

public class HighestNumberFromString {

	public static int solution(String number) {
		if (Objects.isNull(number) || number.length() == 0) {
			return 0;
		}
		if(number.length() <=2)
			return Integer.parseInt(number);
		
		int max_value = Integer.MIN_VALUE;
		for (int x = 0; x < number.length() - 1; x++) {
			max_value = Math.max(max_value, Integer.parseInt(number.substring(x, x + 2)));
		}
		return max_value;
	}

	public static void main(String[] args) {
		System.out.println(solution("50552"));
		System.out.println(solution("10101"));
		System.out.println(solution("88"));
	}
}

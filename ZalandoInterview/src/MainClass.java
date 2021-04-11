import java.util.Objects;

public class MainClass {

	private static final String EMPTY = "";

	public static String runLen(String data) {
		if (Objects.isNull(data) || data.isEmpty()) {
			return EMPTY;
		}
		String result = EMPTY;
		char first = data.charAt(0);
		int count = 1;
		for (int c = 1; c < data.length(); c++) {
			char second = data.charAt(c);
			if (first == second) {
				count++;
			} else {
				result += first + "" + count;
				first = second;
				count = 1;
			}
		}
		result += first + "" + count;
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(runLen("aabbaabb"));
	}
}

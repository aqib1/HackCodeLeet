import java.util.Objects;

public class RotationalCipher1 {
	private static final char MAX_NUM = '9';
	private static final char MIN_NUM = '0';
	private static final char MAX_LOWERCASE_CHAR = 'z';
	private static final char MIN_LOWERCASE_CHAR = 'a';
	private static final char MIN_UPPERCASE_CHAR = 'A';

	public static String rotationalCipher(String input, int rotationFactor) {
		if (Objects.isNull(input) || input.isEmpty())
			return "";

		String result = "";
		for (char chr : input.toCharArray()) {
			char rotated = chr;
			if (Character.isDigit(rotated) || Character.isLetter(rotated)) {
				if (MIN_NUM <= rotated && rotated <= MAX_NUM) {
					rotated = (char) ((rotated - MIN_NUM + rotationFactor) % 10 + MIN_NUM);
				} else if (MIN_LOWERCASE_CHAR <= rotated && rotated <= MAX_LOWERCASE_CHAR) {
					rotated = (char) ((rotated - MIN_LOWERCASE_CHAR + rotationFactor) % 26 + MIN_LOWERCASE_CHAR);
				} else {
					rotated = (char) ((rotated - MIN_UPPERCASE_CHAR + rotationFactor) % 26 + MIN_UPPERCASE_CHAR);
				}
			}
			result += Character.toString(rotated);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(rotationalCipher("Zebra-493?", 3));
	}
}

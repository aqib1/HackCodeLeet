
public class RotationalCipher {

	private static final char MAX_NUM = '9';
	private static final char MIN_NUM = '0';
	private static final char MAX_LOWERCASE_CHAR = 'z';
	private static final char MIN_LOWERCASE_CHAR = 'a';
	private static final char MIN_UPPERCASE_CHAR = 'A';

	public static String rotationalCipher(String input, int rotationFactor) {
		String result = "";
		for (char ch : input.toCharArray()) {
			char rotated = ch;
			if (Character.isDigit(ch) || Character.isLetter(ch)) {
				if (MIN_NUM <= ch && ch <= MAX_NUM) {
					rotated = rotate(ch, MIN_NUM, 10, rotationFactor);
				} else if (MIN_LOWERCASE_CHAR <= ch && ch <= MAX_LOWERCASE_CHAR) {
					rotated = rotate(ch, MIN_LOWERCASE_CHAR, 26, rotationFactor);
				} else {
					rotated = rotate(ch, MIN_UPPERCASE_CHAR, 26, rotationFactor);
				}
			}
			result += Character.toString(rotated);
		}
		return result;
	}

	public static char rotate(char curr, char low, int limit, int rotation) {
		return (char) ((((curr - low) + rotation) % limit) + low);
	}

	public static void main(String[] args) {
//		System.out.println((int)'Z');
//		System.out.println(4 % 26);
		System.out.println(rotationalCipher("Zebra-493?", 3));
	}
}

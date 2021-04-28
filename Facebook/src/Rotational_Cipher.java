import java.util.Objects;

/**
 * Rotational Cipher One simple way to encrypt a string is to "rotate" every
 * alphanumeric character by a certain amount. Rotating a character means
 * replacing it with another character that is a certain number of steps away in
 * normal alphabetic or numerical order. For example, if the string "Zebra-493?"
 * is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic
 * character is replaced with the character 3 letters higher (wrapping around
 * from Z to A), and every numeric character replaced with the character 3
 * digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric
 * characters remain unchanged. Given a string and a rotation factor, return an
 * encrypted string. Signature string rotationalCipher(string input, int
 * rotationFactor) Input 1 <= |input| <= 1,000,000 0 <= rotationFactor <=
 * 1,000,000 Output Return the result of rotating input a number of times equal
 * to rotationFactor. Example 1 input = Zebra-493? rotationFactor = 3 output =
 * Cheud-726? Example 2 input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * rotationFactor = 39 output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 * 
 */
public class Rotational_Cipher {

	private static final char MIN_NUM = '0';
	private static final int NUM_LIMIT = 10;
	private static final char MIN_LOWERCASE_CHAR = 'a';
	private static final char MAX_LOWERCASE_CHAR = 'z';
	private static final char MIN_UPPERCASE_CHAR = 'A';
	private static final int CHAR_LIMIT = 26;

	public static String rotationalCipher(String input, int rotationFactor) {
		if (Objects.isNull(input) || input.isEmpty())
			return null;

		StringBuilder sb = new StringBuilder();

		for (int x = 0; x < input.length(); x++) {
			char current = input.charAt(x);
			if (Character.isDigit(current)) {
				current = (char) ((current - MIN_NUM + rotationFactor) % NUM_LIMIT + MIN_NUM);
			} else if (Character.isLetter(current)) {
				char MIN_LIMIT_CHAR;
				if (current >= MIN_LOWERCASE_CHAR && current <= MAX_LOWERCASE_CHAR) {
					MIN_LIMIT_CHAR = MIN_LOWERCASE_CHAR;
				} else {
					MIN_LIMIT_CHAR = MIN_UPPERCASE_CHAR;
				}
				current = (char) ((current - MIN_LIMIT_CHAR + rotationFactor) % CHAR_LIMIT + MIN_LIMIT_CHAR);
			}

			sb.append(current);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(rotationalCipher("Zebra-493?", 3));
	}
}

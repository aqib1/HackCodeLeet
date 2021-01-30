import java.util.Objects;

public class CreditCard {

	private static final String MASKING_DELIMETER = "#";
	private static final int MASK_EXCLUDED_LIMIT = 6;
	private static final int FIRST_ELEMENT = 0;
	private static final int SECOND_ELEMENT = 1;
	private static final int FOUR = 4;

	public static String maskify(String creditCardNumber) {
		if (validCardExists(creditCardNumber)) {
			return creditCardNumber;
		}
		StringBuilder sb = getStringBuilder(getSubstring(creditCardNumber, FIRST_ELEMENT, SECOND_ELEMENT));
		int maskedLimit = creditCardNumber.length() - FOUR;
		for (int x = 1; x < maskedLimit; x++) {
			char val = creditCardNumber.charAt(x);
			if (Character.isDigit(val)) {
				sb.append(MASKING_DELIMETER);
			} else
				sb.append(Character.toString(val));
		}
		return sb.append(getSubstring(creditCardNumber, maskedLimit, creditCardNumber.length())).toString();
	}

	private static boolean validCardExists(String creditCardNumber) {
		return Objects.isNull(creditCardNumber) || creditCardNumber.length() < MASK_EXCLUDED_LIMIT;
	}

	public static String getSubstring(String value, int inclusive, int exclusive) {
		return value.substring(inclusive, exclusive);
	}

	public static StringBuilder getStringBuilder(String... params) {
		StringBuilder sb = new StringBuilder();
		for (String param : params)
			sb.append(param);
		return sb;
	}

	public static void main(String[] args) {
		System.out.println(maskify("4556364607935616"));
		System.out.println(maskify("4556-3646-0793-5616"));
		System.out.println(maskify("ABCD-EFGH-IJKLM-NOPQ"));
		System.out.println(maskify("A1234567BCDEFG89HI"));
		System.out.println(maskify(""));
		System.out.println(maskify("abcv"));
	}
}

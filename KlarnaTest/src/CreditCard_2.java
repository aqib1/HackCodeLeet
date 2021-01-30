public class CreditCard_2 {

	private static final String MASKED_DELIMETER = "#";
	private static final int LAST_UNMASKED_LENGTH = 4;
	private static final int MINIMUM_MASK_LENGTH = 6;

	public static String maskify(String creditCardNumber) {
		if (requiresMasking(creditCardNumber)) {
			return creditCardNumber;
		}
		StringBuilder creditCardNumberBuilder = getFirstCreditCardCharacter(creditCardNumber);
		int maskedCharacterLength = creditCardNumber.length() - LAST_UNMASKED_LENGTH;
		for (int x = 1; x < maskedCharacterLength; x++) {
			appendIfCharacterOrMaskIsDigit(creditCardNumberBuilder, creditCardNumber.charAt(x));
		}
		return appendLastFourChar(creditCardNumber, creditCardNumberBuilder, maskedCharacterLength);
	}

	private static boolean requiresMasking(String creditCardNumber) {
		return creditCardNumber.isEmpty() || creditCardNumber.length() < MINIMUM_MASK_LENGTH;
	}

	private static String appendLastFourChar(String creditCardNumber, StringBuilder creditCardNumberBuilder,
			int maskedCharacterLength) {
		return creditCardNumberBuilder.append(creditCardNumber.substring(maskedCharacterLength)).toString();
	}

	private static void appendIfCharacterOrMaskIsDigit(StringBuilder sb, char val) {
		if (Character.isDigit(val)) {
			sb.append(MASKED_DELIMETER);
		} else {
			sb.append(Character.toString(val));
		}
	}

	private static StringBuilder getFirstCreditCardCharacter(String creditCardNumber) {
		return new StringBuilder(creditCardNumber.substring(0, 1));
	}

}

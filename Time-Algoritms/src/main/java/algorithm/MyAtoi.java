package algorithm;

public class MyAtoi {

	// O(n) time complexity and space is O(1)
	public static int myAtoi(String str) {
		str = str.trim();
		if (str.isEmpty())
			return 0;
		char c = str.charAt(0);
		if (c != '-' && c != '+' && !Character.isDigit(c)) {
			return 0;
		}
		double number = 0.0;
		number = parseNumber(str);
		return (int) number;
	}

	// "4193 with words"
	private static double parseNumber(String str) {
		int sign = str.charAt(0) == '-' ? -1 : 1;
		double value = 0, mul = 1;
		int x = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0;
		for (; x < str.length(); x++) {
			if (Character.isDigit(str.charAt(x))) {
				value = (value * mul) + Double.parseDouble(String.valueOf(str.charAt(x)));
				mul = 10;
			} else {
				break;
			}
		}
		value *= sign;
		value = value > Integer.MAX_VALUE ? Integer.MAX_VALUE : value < Integer.MIN_VALUE ? Integer.MIN_VALUE : value;
		return value;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("-91283472332"));
	}
}

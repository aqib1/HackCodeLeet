package darkwilderness;

public class LongestNumbPrefix {

	static String longestDigitsPrefix(String inputString) {
		String val = "";
		for (char c : inputString.toCharArray()) {
			if (!Character.isDigit(c))
				break;
			val += c;
		}

		return val;
	}

	public static void main(String[] args) {

	}

}

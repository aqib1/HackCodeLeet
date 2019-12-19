package rainsofreasons;

public class AlphabeticShift {
	static String alphabeticShift(String inputString) {
		String alphabeticShift = "";
		for (char c : inputString.toCharArray()) {
			int v = (int) c;
			if (v == 122)
				alphabeticShift += 'a';
			else
				alphabeticShift += Character.valueOf((char) ++v);
		}

		return alphabeticShift;
	}

	public static void main(String[] args) {
		System.out.println(alphabeticShift("abz"));
	}
}

package RainbowOfClarity;

public class LineEncoding {

	static String lineEncoding(String s) {
		String encode = "";
		int count = 1;
		int index = 1;
		do {

			if (s.charAt(index - 1) == s.charAt(index))
				count++;
			else {
				encode += count == 1 ? "" + s.charAt(index - 1) : count + "" + s.charAt(index - 1);
				count = 1;
			}
			if (++index == s.length() && !encode.endsWith("" + s.charAt(index - 1))) {
				encode += count == 1 ? "" + s.charAt(index - 1) : count + "" + s.charAt(index - 1);
			}
		} while (index < s.length());
		return encode;
	}

	public static void main(String[] args) {
		System.out.println(lineEncoding("abbabb"));
	}
}

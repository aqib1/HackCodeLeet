package LandOfLogics;

public class LongestFlat {

	static String longestWord(String text) {
		int max = Integer.MIN_VALUE;
		String[] values = text.split("[\\s@&.?$+-]+");
		String max_value = "";
		for (String val : values) {
			val = val.replaceAll("[^a-zA-Z]+", "");
			if (max < val.length()) {
				max = val.length();
				max_value = val;
			}
		}
		return max_value;
	}

	public static void main(String[] args) {
		System.out.println(longestWord("Ready[[[ steady go!"));
	}

}

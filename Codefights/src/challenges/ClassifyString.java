package challenges;

import java.util.Arrays;
import java.util.List;

public class ClassifyString {

	static String classifyStrings(String s) {
		if (s.contains("?")) {
			String r1 = getGoodOrBad(getReplaced(s, true));
			String r2 = getGoodOrBad(getReplaced(s, false));
			if (!r1.equals(r2))
				return "mixed";
			else
				return r1;
		} else
			return getGoodOrBad(s);

	}

	private static String getReplaced(String s, boolean vowels) {
		String newString = "";
		for (char c : s.toCharArray()) {
			if (String.valueOf(c).equals("?")) {
				if (vowels)
					newString += "a";
				else
					newString += "x";
			} else {
				newString += String.valueOf(c);
			}
		}
		return newString;
	}

	private static String getGoodOrBad(String s) {
		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
		int c_vowels = 0, c_consonents = 0;
		boolean consec_volwels = false, consec_consonents = false, is_good = true;

		for (char c : s.toCharArray()) {
			String alph = String.valueOf(c);
			if (vowels.contains(alph)) {
				++c_vowels;
				consec_volwels = true;
				consec_consonents = false;
			} else {
				++c_consonents;
				consec_consonents = true;
				consec_volwels = false;
			}
		}
		if (c_vowels >= 3 && consec_volwels) {
			is_good = false;
		} else if (c_consonents >= 5 && consec_consonents) {
			is_good = false;
		}
		return is_good ? "good" : "bad";
	}

	public static void main(String[] args) {
		System.out.println(classifyStrings("???"));
	}

}

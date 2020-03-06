import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Substrings {

	// abc
	/*
	 * 0,1 0,2 0,3 1,2 1,3 2,3
	 **/
	public static Map<String, Integer> allSubStrings(String s) {
		Map<String, Integer> sub = new HashMap<>();
		for (int x = 0; x < s.length(); x++)
			for (int y = (x + 1); y <= s.length(); y++) {
				String v = s.substring(x, y);
				sub.put(v, v.length());
			}
		return sub;
	}

	// t stri -> tist
	public static boolean containsAllCharacters(String v1, String v2) {
		StringBuilder sb = new StringBuilder(v2);
		for (char c : v1.toCharArray()) {
			int index = sb.indexOf(Character.toString(c));
			if (index != -1)
				sb.deleteCharAt(index);
		}
		return sb.length() == 0;
	}

	public static String getWindow(String value, String pattren) {
		if (pattren.isEmpty() || value.isEmpty() || pattren.length() > value.length())
			return "";
		Map<String, Integer> subStrings = allSubStrings(value);
		return subStrings.entrySet().stream().filter(x -> containsAllCharacters(x.getKey(), pattren))
				.min(Comparator.comparing(Entry::getValue)).map(x -> x.getKey()).orElse("");
	}
	
	public static void main(String[] args) {
		System.out.println(getWindow("this is a test string", "tist"));
	}

}

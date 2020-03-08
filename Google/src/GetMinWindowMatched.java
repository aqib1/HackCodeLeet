import java.util.Objects;

public class GetMinWindowMatched {

	private static final int CHAR_MAX_NO = 256;

	public static String getWindow(String value, String pattern) {
		if (Objects.isNull(value) || Objects.isNull(pattern))
			throw new NullPointerException();
		if (pattern.length() > value.length())
			return "";
		int[] count_char_val = new int[CHAR_MAX_NO];
		int[] count_char_pattern = new int[CHAR_MAX_NO];
		for (char c : pattern.toCharArray())
			count_char_pattern[c]++;
		int start = 0, matches = 0, start_index = -1, min_len = Integer.MAX_VALUE;

		for (int x = 0; x < value.length(); x++) {
			char index = value.charAt(x);
			count_char_val[index]++;
			if (count_char_pattern[index] != 0 && count_char_val[index] <= count_char_pattern[index])
				matches++;
			if (matches == pattern.length()) {
				// reduce if there is extra value or not from pattern
				while (count_char_pattern[value.charAt(start)] == 0
						|| count_char_val[value.charAt(start)] > count_char_pattern[value.charAt(start)]) {
					if (count_char_val[value.charAt(start)] > count_char_pattern[value.charAt(start)])
						count_char_val[value.charAt(start)]--;
					start++;
				}
				int len = (x - start) + 1;
				if(min_len > len) {
					min_len = len;
					start_index = start;
				}
				
			}

		}
		if(start_index == -1)
			return "";

		return value.substring(start_index, start_index + min_len);
	}

	public static void main(String[] args) {
		System.out.println(getWindow("this is a test string","tist"));
	}

}

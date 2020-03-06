
public class GetMatchMinWindow {

	private static final int char_limit = 256;

	public static String getWindow(String value, String pattren) {
		if (value.isEmpty() || pattren.isEmpty() || pattren.length() > value.length())
			return "";
		// Count each character in pattern
		int[] count_of_pattrens = new int[char_limit];
		int[] count_of_value = new int[char_limit];
		for (char c : pattren.toCharArray())
			count_of_pattrens[c]++;
		int count = 0, start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
		for (int x = 0; x < value.length(); x++) {
			char index = value.charAt(x);
			count_of_value[index]++;

			if (count_of_pattrens[index] != 0 && count_of_value[index] <= count_of_pattrens[index])
				count++;
			// if pattern matched
			if (count == pattren.length()) {
				// remove extra chars from the beginning
				// remove char which not exists in pattern
				while (count_of_pattrens[value.charAt(start)] == 0
						|| count_of_value[value.charAt(start)] > count_of_pattrens[value.charAt(start)]) {
					if (count_of_value[value.charAt(start)] > count_of_pattrens[value.charAt(start)])
						count_of_value[value.charAt(start)]--;
					start++;
				}

				int window_len = (x - start) + 1;
				if (min_len > window_len) {
					min_len = window_len;
					start_index = start;
				}
			}
		}
		if (start_index == -1)
			return "";
		return value.substring(start, start + min_len);
	}

	public static void main(String[] args) {
		System.out.println(getWindow("this is a test string","tist"));
	}

}

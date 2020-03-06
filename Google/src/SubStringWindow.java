public class SubStringWindow {

	private static final int no_of_chars = 256;

	// tist -> this is a test String
	public static String getWindow(String value, String pattren) {
		int[] countCharsPattren = new int[no_of_chars];
		int[] countCharsOfValue = new int[no_of_chars];
		for (char c : pattren.toCharArray())
			countCharsPattren[c]++;
		int matchCount = 0;
		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
		for (int x = 0; x < value.length(); x++) {
			char index = value.charAt(x);
			countCharsOfValue[index]++;
			if (countCharsPattren[index] != 0 && countCharsOfValue[index] <= countCharsPattren[index])
				matchCount++;

			// Pattern matched
			if (matchCount == pattren.length()) {
				while (countCharsPattren[value.charAt(start)] == 0 || countCharsOfValue[value.charAt(start)] > countCharsPattren[value.charAt(start)]) {
					if (countCharsOfValue[value.charAt(start)] > countCharsPattren[value.charAt(start)])
						countCharsOfValue[value.charAt(start)]--;
					start++;
				}
				
				int len = (x - start) + 1;
				if (len < min_len) {
					min_len = len;
					start_index = start;
				}
			}
			
		}
		if (start_index == -1)
			return "";
		return value.substring(start_index, start_index + min_len);
	}

	public static void main(String[] args) {
		System.out.println(getWindow("this is a test string", "tist"));
	}

}

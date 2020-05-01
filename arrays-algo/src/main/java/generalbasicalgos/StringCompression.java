package generalbasicalgos;

import java.util.Objects;

public class StringCompression {

	//Time complexity O(n) and space complexity O(n)
	public String stringCompression(String string) {
		if (Objects.isNull(string) || string.isEmpty())
			return "";
		if (string.length() == 1)
			return string;

		int count = 1;
		char last = string.charAt(0);
		String result = "";
		for (int x = 1; x < string.length(); x++) {
			if (last == string.charAt(x)) {
				count++;
			} else {
				result += (last + "" + count);
				count = 1;
			}
			last = string.charAt(x);
		}
		result += (last + "" + count);
		return result;
	}
}

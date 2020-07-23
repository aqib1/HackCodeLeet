package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPartitions {

	public static void main(String[] args) {
		System.out.println(partitionString("xabafbaxu"));
	}

	public static List<String> partitionString(String input) {
		if (input.length() == 1)
			return Arrays.asList(input);
		List<String> subStrings = new ArrayList<String>();

		for (int x = 0; x < input.length(); x++) {
			int startIndex = input.indexOf(input.charAt(x));
			int lastIndex = input.lastIndexOf(input.charAt(x));
			for (int y = startIndex; y <= lastIndex; y++) {
				char c = input.charAt(y);
				if (input.lastIndexOf(c) > lastIndex) {
					lastIndex = input.lastIndexOf(c);
				} else if (y == lastIndex) {
					subStrings.add(input.substring(startIndex, lastIndex + 1));
				}
				x = y;
			}

		}

		return subStrings;

	}
}

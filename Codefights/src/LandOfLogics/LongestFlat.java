package LandOfLogics;

import java.util.stream.Stream;

public class LongestFlat {

	static String longestWord(String text) {
		int max = Integer.MIN_VALUE;
		String[] values = text.split("\\W+");
		String max_value = "";
		for (String val : values) {
			if (max < val.length()) {
				max = val.length();
				max_value = val;
			}
		}
		return max_value;
	}
	
	static String longestWordWithStreams(String text) {
		return Stream.of(text.split("\\W+")).max((x,y) -> x.length() - y.length()).get();
	}
	
	public static void main(String[] args) {
		System.out.println(longestWordWithStreams("Ready[[[ steady go!"));
	}

}

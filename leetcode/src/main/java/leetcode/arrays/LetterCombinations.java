package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	
	public static void main(String[] args) {
		LetterCombinations lc = new LetterCombinations();
		System.out.println(lc.letterCombinations("234"));
	
	}
	private static final Map<String, String> numberToString = Map.of("2", "abc", //
			"3", "def", //
			"4", "ghi", //
			"5", "jkl", //
			"6", "mno", //
			"7", "pqrs", //
			"8", "tuv", //
			"9", "wxyz"); //

	private List<String> letterCombinations = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		if (digits.isBlank())
			return letterCombinations;
		calculateCombinations("", digits);
		return letterCombinations;
	}

	public void calculateCombinations(String combination, String digits) {
		if (digits.isEmpty()) {
			letterCombinations.add(combination);
		} else {
			String digit = digits.substring(0, 1);
			String alphabets = numberToString.get(digit);
			for (int i = 0; i < alphabets.length(); i++) {
				String alphabet = alphabets.substring(i, i + 1);
				calculateCombinations(combination + alphabet, digits.substring(1));
			}
		}
	}
}

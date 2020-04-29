package generalbasicalgos;

import java.util.Objects;

public class StringAnagramWithPalindromeSinglePass {

	public boolean canPermutePalindrome(String s) {
		if (Objects.isNull(s) || s.isEmpty())
			return false;
		if (s.length() == 1)
			return true;
		int count = 0;
		int[] charsCount = new int[256];
		for (int x = 0; x < s.length(); x++) {
			charsCount[s.charAt(x)]++;
			count += charsCount[s.charAt(x)] % 2 == 0 ? -1 : 1;
		}
		return count <= 1;
	}
}

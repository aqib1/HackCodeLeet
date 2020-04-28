package generalbasicalgos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringPermutations {

	// Time complexity is O(n)2 and space complexity is O(n)
	public List<String> permutations(String s) {
		List<String> permutations = new ArrayList<>();
		if (Objects.isNull(s) || s.isEmpty())
			return new ArrayList<>();
		permutations(s, 0, s.length(), permutations);
		return permutations;
	}

	private void permutations(String s, int l, int r, List<String> permutations) {
		if (l == r)
			permutations.add(s);
		else {
			for (int x = l; x < r; x++) {
				s = swap(s, x, l);
				permutations(s, l + 1, r, permutations);
				s = swap(s, x, l);
			}
		}
	}

	private String swap(String s, int x, int l) {
		char[] charArr = s.toCharArray();
		char temp = charArr[x];
		charArr[x] = charArr[l];
		charArr[l] = temp;
		return String.valueOf(charArr);
	}
}

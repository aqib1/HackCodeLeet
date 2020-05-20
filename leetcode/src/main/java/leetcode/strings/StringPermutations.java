package leetcode.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringPermutations {
	public List<String> permutation(String s) {
		if (Objects.isNull(s) || s.isEmpty())
			return new ArrayList<>();
		List<String> list = new ArrayList<String>();
		permutation(list, s, 0, s.length());
		return list;
	}

	private void permutation(List<String> list, String s, int l, int r) {
		if (l == r)
			list.add(s);
		else {
			for (int x = l; x < r; x++) {
				s = swap(s, x, l);
				permutation(list, s, l + 1, r);
				s = swap(s, x, l);
			}
		}
	}

	private String swap(String s, int x, int l) {
		char[] data = s.toCharArray();
		char temp = data[l];
		data[l] = data[x];
		data[x] = temp;
		return String.valueOf(data);
	}

}

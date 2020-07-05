package algorithm;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		System.out.println(sp.permutation("ABC"));
	}

	public List<String> permutation(String value) {
		List<String> permutations = new ArrayList<>();
		permutation(permutations, value, 0, value.length());
		return permutations;
	}

	private void permutation(List<String> permutations, String value, int l, int r) {
		if (l == r)
			permutations.add(value);
		else {
			for (int x = l; x < r; x++) {
				value = swap(value, x, l);
				permutation(permutations, value, l + 1, r);
				value = swap(value, x, l);
			}
		}

	}

	private String swap(String value, int x, int l) {
		char[] arr = value.toCharArray();
		char c = arr[x];
		arr[x] = arr[l];
		arr[l] = c;
		return String.valueOf(arr);
	}
}

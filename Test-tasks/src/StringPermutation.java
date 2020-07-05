import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static List<String> permutation(String value) {
		List<String> perms = new ArrayList<>();
		permutation(perms, value, 0, value.length());
		return perms;
	}

	private static void permutation(List<String> perms, String value, int l, int r) {
		if (l == r)
			perms.add(value);
		else {
			for (int x = l; x < r; x++) {
				value = swap(value, x, l);
				permutation(perms, value, l + 1, r);
				value = swap(value, x, l);
			}
		}

	}

	private static String swap(String value, int x, int l) {
		char[] arr = value.toCharArray();
		char c = arr[x];
		arr[x] = arr[l];
		arr[l] = c;
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		System.out.println(permutation("ABC"));
	}
}

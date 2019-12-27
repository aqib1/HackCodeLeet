package Throughthefog;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationRearrangement {

	static boolean differByOne(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
		}
		return count == 1;
	}

	static boolean stringsRearrangement(String[] inputArray) {

		return true;
	}

	static List<String> permutingArray(java.util.List<String> arrayList, int element) {
		List<String> perm = new ArrayList<>();
		for (int i = element; i < arrayList.size(); i++) {
			java.util.Collections.swap(arrayList, i, element);
			permutingArray(arrayList, element + 1);
			java.util.Collections.swap(arrayList, element, i);
		}

		if (element == arrayList.size() - 1) {
			perm.add(java.util.Arrays.toString(arrayList.toArray()));
		}
		return perm;
	}

	public static void main(String[] args) {

	}
}

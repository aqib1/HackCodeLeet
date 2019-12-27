package Throughthefog;

import java.util.ArrayList;
import java.util.Arrays;
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
		List<List<String>> perm = permutingArray(Arrays.asList(inputArray), 0);
		for(List<String> s : perm)
			System.out.println(s);
		boolean ans = false;
		for (List<String> current: perm) {
			if(check(current)) ans = true;
		}
		return ans;
	}
	static boolean check(List<String> ar) {
		for (int i = 1; i < ar.size(); i++) {
			int diffCount = count(ar.get(i-1), ar.get(i));
			if (diffCount != 1) return false;
		}
		return true;
	}

	static int count(String s1, String s2) {
		int count = 0;
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) count++;
		}
		return count;
	}

	static List<List<String>> perm = new ArrayList<>();

	static List<List<String>> permutingArray(java.util.List<String> arrayList, int element) {
		for (int x = element; x < arrayList.size(); x++) {
			java.util.Collections.swap(arrayList, x, element);
			permutingArray(arrayList, element + 1);
			java.util.Collections.swap(arrayList, element, x);
		}
		if (element == arrayList.size() - 1) {
			perm.add(new ArrayList<String>(arrayList));
		}
		return perm;
	}

	public static void main(String[] args) {
		System.out.println(stringsRearrangement(new String[] {"abc", 
				 "abx", 
				 "axx", 
				 "abc"}));
	}
}

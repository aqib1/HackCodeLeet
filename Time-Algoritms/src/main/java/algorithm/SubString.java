package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubString {
	public static void main(String[] args) {
		System.out.println(subStrings("bacbxzecvacbxzecvb"));

	}

	public static List<String> subStrings(String val) {
		if (val == null || val.length() == 0)
			return Arrays.asList();
		// Time complexity On2 and space O(n)
		List<String> subStrings = new ArrayList<>();
		skip: for (int x = 0; x < val.length(); x++) {
			for (int y = x - 1; y >= 0; y--) {
				if (val.charAt(y) == val.charAt(x))
					continue skip;
			}
			int lastIndex = val.lastIndexOf(val.charAt(x));
			if (lastIndex == -1)
				subStrings.add(val.substring(x, x + 1));
			else
				subStrings.add(val.substring(x, lastIndex + 1));
		}

		int max_len = Integer.MIN_VALUE;
		List<String> result = null;

		// Space complexity is O2^n and time complexity is On2
		List<List<String>> powersets = getAllPowerSets(subStrings);
		// Filter non repeated all possible occurrence O(n2) with space O(n)
		List<List<String>> filterNonRepeated = fiter(powersets);
		for (List<String> s : filterNonRepeated) {
			if (max_len <= s.size()) {
				if (max_len == s.size() && result != null) {
					// Time complexity On using java 8 streams for concat
					result = maxElementArray(result, s);
				} else {
					result = s;
				}

				max_len = s.size();
			}
		}

		return result;

	}

	private static List<String> maxElementArray(List<String> result, List<String> news) {
		String r = result.stream().reduce("", String::concat);
		String n = news.stream().reduce("", String::concat);
		return r.length() > n.length() ? news : result;
	}

	private static List<List<String>> fiter(List<List<String>> powersets) {
		List<List<String>> filter = new ArrayList<>();
		step: for (List<String> powerset : powersets) {
			if (powerset.isEmpty())
				continue step;
			String curr = powerset.get(0);
			for (int x = 1; x < powerset.size(); x++) {
				if (containsAny(curr, powerset.get(x))) {
					continue step;
				} else {
					curr += powerset.get(x);
				}
			}
			filter.add(powerset);
		}
		return filter;
	}

	private static List<List<String>> getAllPowerSets(List<String> subStrings) {
		List<List<String>> powersets = new ArrayList<>();
		calculatePowersets(powersets, new ArrayList<>(), subStrings, 0);
		return powersets;
	}

	private static void calculatePowersets(List<List<String>> powersets, ArrayList<String> result,
			List<String> subStrings, int start) {
		powersets.add(new ArrayList<String>(result));
		for (int s = start; s < subStrings.size(); s++) {
			result.add(subStrings.get(s));
			calculatePowersets(powersets, result, subStrings, s + 1);
			result.remove(result.size() - 1);
		}

	}

	// O(n)
	public static boolean containsAny(String s1, String s2) {
		for (char c : s1.toCharArray()) {
			for (char d : s2.toCharArray()) {
				if (c == d)
					return true;
			}
		}

		return false;
	}
}

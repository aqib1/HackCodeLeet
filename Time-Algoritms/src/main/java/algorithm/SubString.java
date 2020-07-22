package algorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SubString {
	public static void main(String[] args) {
		System.out.println(findSubStrings("bacbxzecvacbxzecvb"));

	}

	public static List<String> findSubStrings(String str) {
		Map<String, Long> occurences = new LinkedHashMap<>();

		for (char alphabet : str.toCharArray()) {
			if (str.chars().filter(ch -> ch == alphabet).count() > 0) {
				occurences.put(String.valueOf(alphabet), str.chars().filter(ch -> ch == alphabet).count());
			}
		}

		List<String> subStrings = new ArrayList<>();

		List<String> possibleLargerSubstrings = occurences.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(Map.Entry::getKey).collect(Collectors.toList());
		Set<String> singleOccurencesSubStrings = occurences.entrySet().stream().filter(entry -> entry.getValue() == 1)
				.map(Map.Entry::getKey).collect(Collectors.toSet());

		for (String x : possibleLargerSubstrings) {
			int firstIndex = str.indexOf(x);
			int lastIndex = str.lastIndexOf(x);
			List<String> removalCandidates = new ArrayList<>();
			for (int i = firstIndex; i < lastIndex; i++) {
				if (singleOccurencesSubStrings.contains(str.charAt(i)) || (str.lastIndexOf(str.charAt(i)) < lastIndex
						&& doesNotContainElements(String.valueOf(str.charAt(i)), removalCandidates)
						&& !String.valueOf(str.charAt(i)).equals(x))) {
					possibleLargerSubstrings.removeAll(removalCandidates);
					// possibleLargerSubstrings.remove(String.valueOf(str.charAt(i)));
					break;
				} else if (str.lastIndexOf(str.charAt(i)) > lastIndex) {
					lastIndex = str.lastIndexOf(str.charAt(i));
					removalCandidates.add(String.valueOf(str.charAt(i)));
				} else if (i == lastIndex - 1) {
					subStrings.add(str.substring(firstIndex, lastIndex + 1));
					possibleLargerSubstrings.removeAll(removalCandidates);
				}
			}
		}

		subStrings.addAll(singleOccurencesSubStrings.stream().collect(Collectors.toList()));

		return subStrings;
	}

	public static boolean doesNotContainElements(String str, List<String> list) {
		for (String element : list) {
			if (element.equals(str)) {
				return false;
			}
		}

		return true;
	}
}

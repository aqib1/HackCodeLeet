package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SubStringSimpleSolution {

	public static void main(String[] args) {
//		System.out.println(subStrings("bb"));
//		System.out.println(subStrings("bbx"));
//		System.out.println(subStrings("baabx"));
//		System.out.println(subStrings("baccabx"));
//		System.out.println(subStrings("bvcb"));
//		System.out.println(subStrings("bffaddtavdeecxb"));
//		System.out.println(subStrings("baba"));
//		System.out.println(subStrings("baddacxbff"));
//		System.out.println(subStrings("abcdadcba"));
//		System.out.println(subStrings("baddacxb"));

//		System.out.println(subStrings("baaxaxabeaeeeeeeeee"));
	}

	// Walk through
	public static List<String> subStrings(String value) {

		Map<Character, Long> charactersCount = value.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
		Set<Character> single = charactersCount.entrySet().stream().filter(x -> x.getValue() == 1L).map(x -> x.getKey())
				.collect(Collectors.toSet());
		List<Character> multipleValue = new ArrayList<>();
		for (char c : value.toCharArray()) {
			if (charactersCount.get(c) > 1L) {
				multipleValue.add(c);
			}
		}

		List<String> subStrings = new ArrayList<>();
		subStrings.addAll(single.stream().map(x -> String.valueOf(x)).collect(Collectors.toList()));
		while (!multipleValue.isEmpty()) {
			char multiple = multipleValue.get(0);
			int start = value.indexOf(multiple);
			int end = value.lastIndexOf(multiple);
			Set<Character> valuesToRemove = new HashSet<>();
			for (int index = start; index <= end; index++) {
				char current = value.charAt(index);
				if (single.contains(current)) {
					multipleValue.removeAll(valuesToRemove);
					break;
				} else if (value.lastIndexOf(current) < end && index != value.lastIndexOf(current)) {
					if (!containsAny(valuesToRemove, value.substring(index, value.lastIndexOf(current) + 1))) {
						multipleValue.removeAll(valuesToRemove);
						break;
					}
				} else if (value.lastIndexOf(current) > end) {
					if (!containsAny(valuesToRemove, String.valueOf(current))) {
						valuesToRemove.add(current);
					}
					end = value.lastIndexOf(current);

				} else if (index == end) {
					multipleValue.removeAll(valuesToRemove);
					subStrings.add(value.substring(start, end + 1));
				}

				if (value.lastIndexOf(current) <= end) {
					valuesToRemove.add(current);
				}
			}
		}

		return subStrings;
	}

	private static boolean containsAny(Set<Character> valuesToRemove, String substring) {
		if (substring == null || substring.isEmpty())
			return false;
//		if (substring.length() == 1)
//			return true;
		for (int x = 1; x < substring.length() - 1; x++)
			if (valuesToRemove.contains(substring.charAt(x)))
				return true;
		return false;
	}

}

package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Amazon2k20_Mn_FilmProblem {

	static List<Integer> lengthEachScene(List<Character> inputList) {
		String inputString = inputList.stream().map(String::valueOf).collect(Collectors.joining());
		List<Integer> lengths = new ArrayList<>();
		calculateSubStrings(inputString, lengths);
		return lengths;
	}

	private static void calculateSubStrings(String inputString, List<Integer> lengths) {
		if (inputString.isEmpty())
			return;
		Map<String, Long> occurences = new LinkedHashMap<>();

		for (char alphabet : inputString.toCharArray()) {
			if (!occurences.containsKey(String.valueOf(alphabet))) {
				occurences.put(String.valueOf(alphabet), 1L);
			} else {
				occurences.put(String.valueOf(alphabet), occurences.get(String.valueOf(alphabet)) + 1);
			}
		}
		List<String> multipleChars = occurences.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(Map.Entry::getKey).collect(Collectors.toList());
		List<String> singleChars = occurences.entrySet().stream().filter(entry -> entry.getValue() == 1)
				.map(Map.Entry::getKey).collect(Collectors.toList());

		while (!multipleChars.isEmpty()) {
			String multiple = multipleChars.get(0);
			int firstIndex = inputString.indexOf(multiple);
			int lastIndex = inputString.lastIndexOf(multiple);
			List<String> removalCandidates = new ArrayList<>();
			for (int i = firstIndex; i <= lastIndex; i++) {
				String current = String.valueOf(inputString.charAt(i));
				if (singleChars.contains(current)) {
					singleChars.remove(current);
				} else if (inputString.lastIndexOf(current) > lastIndex) {
					lastIndex = inputString.lastIndexOf(current);
					removalCandidates.add(current);
				} else if (i == lastIndex) {
					lengths.add((lastIndex - firstIndex) + 1);
					multipleChars.removeAll(removalCandidates);
				}
				if (inputString.lastIndexOf(current) <= lastIndex)
					removalCandidates.add(current);
			}
		}
		for (int x = 0; x < singleChars.size(); x++)
			lengths.add(1);
	}

	public static void main(String[] args) {
		System.out.println(lengthEachScene(Arrays.asList('a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f',
				'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j')));
	}
}

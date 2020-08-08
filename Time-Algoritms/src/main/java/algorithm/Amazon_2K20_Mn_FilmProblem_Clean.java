package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amazon_2K20_Mn_FilmProblem_Clean {

	// O(n) time complexity with O(26) space complexity
	static List<Integer> lengthEachScene(List<Character> inputList) {
		List<Integer> lengths = new ArrayList<>();
		int[] lastIndexMap = new int[26];
		for (int index = 0; index < inputList.size(); index++) {
			lastIndexMap[inputList.get(index) - 'a'] = index;
		}
		int start = 0, end = 0;
		for (int index = 0; index < inputList.size(); index++) {
			end = Math.max(end, lastIndexMap[inputList.get(index) - 'a']);
			if (end == index) {
				lengths.add(end - start + 1);
				start = end + 1;
			}
		}
		return lengths;
	}

	public static void main(String[] args) {
		System.out.println(lengthEachScene(Arrays.asList('a', 'b', 'c')));
	}
}

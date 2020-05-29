package amazon;

import java.util.HashMap;

public class ShortestSubSegmant {

	// Sliding windows approach
	// Time complexity O(N) and Space Complexity O(N)
	public String shortestSubSegment(String paragraph, int k, String[] words) {
		HashMap<String, Integer> wordsToCount = new HashMap<>();
		for (String word : words)
			wordsToCount.put(word.toLowerCase(), 0);
		String[] splitedPara = paragraph.split("\\W+");
		int i = 0, j = 0, start = 0, end = 0, index = -1;
		int min_val = Integer.MAX_VALUE;
		while (i < splitedPara.length && j < splitedPara.length) {
			boolean notFull = wordsToCount.values().contains(0);
			index = notFull ? j : i;
			String key = splitedPara[index].toLowerCase();
			if (notFull) {
				if (wordsToCount.containsKey(key)) {
					wordsToCount.put(key, wordsToCount.get(key) + 1);
				}
			} else {
				if ((j - i) < min_val) {
					min_val = (j - i);
					start = i;
					end = j - 1;
				}
				if (wordsToCount.containsKey(key)) {
					wordsToCount.put(key, wordsToCount.get(key) - 1);
				}
			}
			if (notFull)
				++j;
			else
				++i;
		}
		return min_val == Integer.MAX_VALUE ? "NO SUBSEGMENT FOUND" : getResultStr(splitedPara, start, end);
	}

	private String getResultStr(String[] splitedPara, int i, int j) {
		String result = "";
		for (int x = i; x <= j; x++) {
			result += splitedPara[x];
			if (x < j) {
				result += " ";
			}
		}
		return result;
	}
}

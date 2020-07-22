package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class TopBuzzWords {

	private static final String EMPTY = " ";

	public static void main(String[] args) {
		System.out.println(getTopToys(6, 2, new String[] { "elmo", "elsa", "legos", "drone", "tablet", "warcraft" }, 6,
				new String[] { "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
						"The new Elmo dolls are super high quality",
						"Expect the Elsa dolls to be very popular this year, Elsa",
						"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
						"For parents of older kids, look into buying them a drone",
						"Warcraft is slowly rising in popularity ahead of the holiday season" }));
	}

	// Time complexity On2 for counting and O(logN) for max heap overall O(n2)
	// Space complexity is O(N) from Map and O(N) for max heap and O(toNCompetitors)
	// overall O(n)

	public static List<String> getTopToys(int numCompetitors, int topNCompetitors, String[] competitors, int numReviews,
			String[] reviews) {

		// Map creation for storing sum
		Map<String, Integer> countMap = new HashMap<>();
		for (String competitor : competitors) {
			for (String review : reviews) {
				if (review.toUpperCase().contains(EMPTY.concat(competitor.toUpperCase()).concat(EMPTY))) {
					countMap.putIfAbsent(competitor, 1);
					countMap.put(competitor, countMap.get(competitor) + 1);
				}
			}
		}

		// Create a max heap
		PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> Integer.compare(b.getValue(), a.getValue()));

		countMap.entrySet().forEach(entry -> maxHeap.add(entry));
		List<String> result = new ArrayList<>();
		IntStream.range(0, topNCompetitors).forEach(x -> result.add(maxHeap.poll().getKey()));
		return result;

	}
}

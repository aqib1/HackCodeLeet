import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Task3 {

	public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords,
		List<Integer> hotelIds, List<String> reviews, int k) {
		if(k == 0 || reviews.isEmpty() || positiveKeywords.isBlank() || negativeKeywords.isBlank())
			return Arrays.asList();
		List<Integer> result = new ArrayList<>();
		Set<String> positiveKeys = new HashSet<>(Arrays.asList(positiveKeywords.split(" ")));
		Set<String> negativeKeys = new HashSet<>(Arrays.asList(negativeKeywords.split(" ")));
		Queue<Entry<Integer, Integer>> max_heap = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
		Map<Integer, Integer> idByReview = new HashMap<>();
		for(int x=0; x < hotelIds.size(); x++) {
			if(containsAny(positiveKeys, reviews.get(x))) {
				addToMap(3, hotelIds.get(x), idByReview);
			} else if(containsAny(negativeKeys, reviews.get(x))) {
				addToMap(-1, hotelIds.get(x), idByReview);
			}
		}
		max_heap.addAll(idByReview.entrySet());
		for(int x=0; x<k && !max_heap.isEmpty(); x++) {
			result.add(max_heap.remove().getKey());
		}
		return result;
	}
	
	private static void addToMap(int score, Integer hotelId, Map<Integer, Integer> idByReview) {
		if(idByReview.containsKey(hotelId)) {
			idByReview.put(hotelId, idByReview.get(hotelId) + score);
		} else {
			idByReview.put(hotelId, score);
		}
		
	}

	public static boolean containsAny(Set<String> keys, String paragraph) {
		return keys.stream().parallel().anyMatch(x -> paragraph.indexOf(x) > -1);
	}
}

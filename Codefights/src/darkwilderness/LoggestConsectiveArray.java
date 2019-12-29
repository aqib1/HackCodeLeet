package darkwilderness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LoggestConsectiveArray {
	static List<Integer> longestConsectiveArray(List<Integer> li) {
		List<List<Integer>> data = new ArrayList<>();
		List<Integer> sub = new ArrayList<>();
		for (int x = 1; x < li.size(); x++) {
			if (Math.abs(li.get(x - 1) - li.get(x)) == 1) {
				sub.add(li.get(x - 1));
			} else {
				sub.add(li.get(x - 1));
				data.add(sub);
				sub = new ArrayList<Integer>();
			}
		}
		if (!data.contains(sub)) {
			sub.add(li.get(li.size() - 1));
			data.add(sub);
		}
		return data.stream().max(Comparator.comparing(List::size)).get();
	}

	public static void main(String[] args) {
		System.out.println(longestConsectiveArray(Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9)));
	}
}

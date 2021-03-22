import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution5 {

	public static void main(String[] args) {
		List<List<Integer>> grid = Arrays.asList(
				Arrays.asList(1, 1, 1, 1, 1, 1),
				Arrays.asList(1, 1, 0, 0, 0, 0),
				Arrays.asList(0, 0, 0, 1, 1, 1), 
				Arrays.asList(0, 0, 0, 1, 1, 1), 
				Arrays.asList(0, 0, 1, 0, 0, 0),
				Arrays.asList(1, 0, 0, 0, 0, 0));
		System.out.println(onesGroups(grid, Arrays.asList(6, 1, 8, 2)));
	}

	private static int distance[] = { 0, 1, 0, -1, 0 };
	private static int count = 0;

	public static List<Integer> onesGroups(List<List<Integer>> grid, List<Integer> queries) {
		Map<Integer, Integer> calOnes = cal(grid);
		List<Integer> result = new ArrayList<Integer>();
		for (int query : queries) {
			if (calOnes.containsKey(query))
				result.add(calOnes.get(query));
			else
				result.add(0);
		}
		return result;

	}

	private static Map<Integer, Integer> cal(List<List<Integer>> grid) {
		Map<Integer, Integer> cal = new HashMap<>();
		for (int row = 0; row < grid.size(); row++) {
			for (int col = 0; col < grid.get(row).size(); col++) {
				if (grid.get(row).get(col) == 1) {
					count = 1;
					cal(grid, row, col);
					if (cal.containsKey(count)) {
						cal.put(count, cal.get(count) + 1);
					} else
						cal.put(count, 1);
				}
			}
		}
		return cal;
	}

	private static void cal(List<List<Integer>> grid, int row, int col) {
		grid.get(row).set(col, -1);
		for (int d = 0; d < distance.length - 1; d++) {
			int newRow = row + distance[d];
			int newCol = col + distance[d + 1];
			if (newRow >= 0 && newRow < grid.size() && newCol >= 0 && newCol < grid.get(newRow).size() && grid.get(newRow).get(newCol) == 1) {
				++count;
				cal(grid, newRow, newCol);
			}
		}
	}
}

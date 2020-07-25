package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Amazon2k20_NoOfAmazonTreasureTrucks {

	public static void main(String[] args) {
		List<List<Integer>> grids = new ArrayList<>();
		grids.add(Arrays.asList(1, 1, 1, 1));
		grids.add(Arrays.asList(0, 1, 0, 0));
		grids.add(Arrays.asList(0, 0, 0, 0));
		grids.add(Arrays.asList(0, 0, 1, 1));
		grids.add(Arrays.asList(1, 1, 1, 1));

		System.out.println(numberOfAmazonTreasureTrucks(5, 4, grids));
	}

	public static int numberOfAmazonTreasureTrucks(int rows, int columns, List<List<Integer>> grids) {
		boolean visited[][] = new boolean[rows][columns];
		int numberOfTreasureTrucks = 0;
		Queue<int[]> indexes = new LinkedList<>();
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				if (!visited[row][col] && grids.get(row).get(col) == 1) {
					indexes.add(new int[] { row, col });
					bfs(visited, indexes, grids);
					numberOfTreasureTrucks++;
				}
			}
		}
		return numberOfTreasureTrucks;
	}

	private static void bfs(boolean[][] visited, Queue<int[]> indexes, List<List<Integer>> grids) {
		int H = grids.size();
		int L = grids.get(0).size();

		while (indexes.isEmpty() == false) {
			int index[] = indexes.remove();
			if (index[0] < 0 || index[1] < 0 || index[0] >= H || index[1] >= L || visited[index[0]][index[1]]
					|| grids.get(index[0]).get(index[1]) != 1)
				continue;

			visited[index[0]][index[1]] = true;
			indexes.add(new int[] { index[0], (index[1] - 1) }); // go left
			indexes.add(new int[] { index[0], (index[1] + 1) }); // go right
			indexes.add(new int[] { index[0] - 1, (index[1]) }); // go up
			indexes.add(new int[] { index[0] + 1, (index[1]) }); // go down
		}

	}
}

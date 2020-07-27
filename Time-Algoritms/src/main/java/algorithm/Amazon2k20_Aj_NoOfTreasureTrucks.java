package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Amazon2k20_Aj_NoOfTreasureTrucks {

	public static void main(String[] args) {
		Amazon2k20_Aj_NoOfTreasureTrucks noOfTreasureTrucks = new Amazon2k20_Aj_NoOfTreasureTrucks();
		List<List<Integer>> grids = new ArrayList<>();
		grids.add(Arrays.asList(1, 1, 1, 1));
		grids.add(Arrays.asList(0, 1, 0, 0));
		grids.add(Arrays.asList(1, 0, 0, 0));
		grids.add(Arrays.asList(0, 0, 1, 1));
		grids.add(Arrays.asList(1, 1, 1, 1));

		System.out.println(noOfTreasureTrucks.numberOfAmazonTreasureTrucks(5, 4, grids));
	}

	private final int[] directions = { 0, -1, 0, 1, 0 };

	// Time complexity is O(n)2 and space complexity is O(5) for direction array
	public int numberOfAmazonTreasureTrucks(int rows, int columns, List<List<Integer>> grids) {
		if (Objects.isNull(grids) || grids.isEmpty())
			return 0;
		int treasureTrucks = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				if (grids.get(row).get(col) == 1) {
					markingContiguousPark(grids, row, col);
					treasureTrucks++;
				}
			}
		}
		return treasureTrucks;
	}

	private void markingContiguousPark(List<List<Integer>> grids, int row, int col) {
		grids.get(row).set(col, -1);

		IntStream.range(0, directions.length - 1).forEach(direction -> {
			int newRow = row + directions[direction];
			int newCol = col + directions[direction + 1];
			if (newRow >= 0 && newRow < grids.size() && newCol >= 0 && newCol < grids.get(newRow).size()
					&& grids.get(newRow).get(newCol) == 1)
				markingContiguousPark(grids, newRow, newCol);
		});
	}
}

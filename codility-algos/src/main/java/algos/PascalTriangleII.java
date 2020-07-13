package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex == 0)
			return Arrays.asList(1);
		List<List<Integer>> result = new ArrayList<>();
		result.add(Arrays.asList(1));

		for (int x = 1; x <= rowIndex; x++) {
			List<Integer> data = new ArrayList<>();
			data.add(1);
			for (int y = 1; y < x; y++) {
				data.add(result.get(x - 1).get(y - 1) + result.get(x - 1).get(y));
			}
			data.add(1);
			result.add(data);
		}

		return result.get(rowIndex);
	}
}

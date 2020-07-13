package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * input = 5 [ 
 *	 	[1], 
 *	   [1,1], 
 *	  [1,2,1], 
 *	 [1,3,3,1], 
 *	[1,4,6,4,1] ]
 * 
 */
public class PascalTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	// Time complexity is O(n) and space is O(n)
	public static List<List<Integer>> generate(int numRows) {
		if (numRows < 1)
			return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		result.add(Arrays.asList(1));

		for (int x = 1; x < numRows; x++) {
			List<Integer> data = new ArrayList<>();
			data.add(1);
			for (int y = 1; y < x; y++) {
				data.add(result.get(x-1).get(y - 1) + result.get(x-1).get(y));
			}
			data.add(1);
			result.add(data);
		}

		return result;
	}
}

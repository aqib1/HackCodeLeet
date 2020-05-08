package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

	/*
	 * 		[ [1], 
	 *  	 [1,1], 
	 * 		[1,2,1], 
	 * 	   [1,3,3,1], 
	 * 	  [1,4,6,4,1] ]
	 */

	public List<List<Integer>> generate(int numRows) {
		if (numRows == 0)
			return new ArrayList<>();
		List<List<Integer>> li = new ArrayList<>();
		li.add(Arrays.asList(1));
		for (int x = 1; x < numRows; x++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = li.get(x - 1);
			row.add(1);
			for (int y = 1; y < prevRow.size(); y++) {
				row.add(prevRow.get(y) + prevRow.get(y-1));
			}
			row.add(1);
			li.add(row);
		}
		return li;
	}
}

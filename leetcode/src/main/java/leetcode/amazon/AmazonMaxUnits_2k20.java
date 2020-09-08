package leetcode.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * An Amazon warehouse manager needs to create a shipment to fill a truck, All
 * of the products in the warehouse are in the boxes of the same size, each
 * product is packed in some number units per box. Given the number of boxes the
 * truck can hold, write an algorithm to determine, the maximum number of units
 * of any mix of products that can be shipped.
 * 
 * Input : The input to the function/method consists of five arguments, num, an
 * integer representing number of products, boxes, a list of integers
 * representing the number of available boxes for products, unitSize, an integer
 * representing size of unitsPerBox, unitsPerBox, a list of integers
 * representing the number of units packed in each box; truckSize, an integer
 * representing the number of boxes the truck can carry.
 * 
 * Output : Return an integer representing the maximum units that can be carried
 * by the truck.
 */

public class AmazonMaxUnits_2k20 {
	public static void main(String[] args) {
		System.out.println(getMaxUnit(3, Arrays.asList(1, 2, 2), 3, Arrays.asList(3, 2, 3), 3));
	}

	// Time complexity is O(nlogn) and space is O(n)
	public static long getMaxUnit(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox,
			long truckSize) {
		if (num != unitSize)
			throw new IllegalArgumentException("Number of boxes must equals to unit size");

		Map<Integer, Integer> unitSizeByNoOfBoxes = new HashMap<>();
		long result = 0;
		for (int x = 0; x < num; x++) {
			unitSizeByNoOfBoxes.put(unitsPerBox.get(x), boxes.get(x));
		}
		PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		for (int keys : unitSizeByNoOfBoxes.keySet()) {
			max_heap.add(keys);
		}

		while (truckSize > 0) {
			int maxUnit = max_heap.poll();
			int numberOfBoxes = unitSizeByNoOfBoxes.get(maxUnit);
			result += ((numberOfBoxes > truckSize ? numberOfBoxes - truckSize : numberOfBoxes) * maxUnit);
			truckSize -= numberOfBoxes;
		}

		return result;
	}
}

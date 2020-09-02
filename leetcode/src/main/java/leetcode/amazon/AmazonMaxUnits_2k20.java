package leetcode.amazon;

import java.util.ArrayList;
import java.util.HashMap;

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
	public static long getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox,
			long truckSize) {
		Map<Integer, Integer> unitSizeByNoOfBoxes = new HashMap<>();
		return 0;
	}
}

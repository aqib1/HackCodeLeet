package leetcode.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TruckLoaderAlgorithm {

	private static final int AMAZON_TRUCK_TOLERANCE = 30;

	public List<Integer> idsOfPackages(int truckSpace, List<Integer> packagesSpace) {
		if (Objects.isNull(packagesSpace) || packagesSpace.isEmpty())
			throw new IllegalArgumentException("Packages spaces list can not be empty");
		if (truckSpace < AMAZON_TRUCK_TOLERANCE)
			throw new IllegalArgumentException("Truck does not have enough space");
		int first_max = Integer.MIN_VALUE;
		int second_max = Integer.MIN_VALUE;
		int limitSpace = truckSpace - AMAZON_TRUCK_TOLERANCE;
		Integer result[] = new Integer[2];
		for (int x = 0; x < packagesSpace.size(); x++) {
			for (int y = x + 1; y < packagesSpace.size(); y++) {
				if ((limitSpace == packagesSpace.get(x) + packagesSpace.get(y)) && isPairHaveLargestPackage(first_max,
						second_max, packagesSpace.get(x), packagesSpace.get(y))) {
					result[0] = x;
					result[1] = y;
					first_max = packagesSpace.get(x);
					second_max = packagesSpace.get(y);
				}
			}
		}
		return Arrays.asList(result);
	}

	private boolean isPairHaveLargestPackage(int first_max, int second_max, Integer v1, Integer v2) {
		return (v1 > first_max && v1 > second_max) || (v2 > first_max && v2 > second_max);
	}
}

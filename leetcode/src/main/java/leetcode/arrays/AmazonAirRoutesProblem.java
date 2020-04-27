package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AmazonAirRoutesProblem {
	public List<int[]> getAirRoutes(int maxTravelDist, List<int[]> forwardRoutes, List<int[]> backwordRoutes) {
		if (Objects.isNull(forwardRoutes) && Objects.isNull(backwordRoutes)) {
			throw new IllegalArgumentException("routes are null");
		}
		if ((forwardRoutes.isEmpty() && backwordRoutes.isEmpty())) {
			return Arrays.asList(new int[] {});
		}
		Collections.sort(forwardRoutes, (z, y) -> z[1] - y[1]);
		Collections.sort(backwordRoutes, (z, y) -> z[1] - y[1]);
		int max_value = Integer.MIN_VALUE;
		List<int[]> result = new ArrayList<>();
		for (int x = forwardRoutes.size() - 1; x >= 0; x--) {
			for (int y = backwordRoutes.size() - 1; y >= 0; y--) {
				int sum = forwardRoutes.get(x)[1] + backwordRoutes.get(y)[1];
				if (sum > maxTravelDist)
					continue;
				if (max_value <= sum && sum <= maxTravelDist) {
					max_value = sum;
					result.add(new int[] { forwardRoutes.get(x)[0], backwordRoutes.get(y)[0] });
				} else {
					break;
				}
			}
		}

		return result;
	}
}

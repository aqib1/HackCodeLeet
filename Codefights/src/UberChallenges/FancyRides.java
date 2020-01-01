package UberChallenges;

import java.util.stream.DoubleStream;

public class FancyRides {

	static String fancyRide(int l, double[] fares) {
		String[] cars = { "UberX", "UberXL", "UberPlus", "UberBlack", "UberSUV" };

		double[] faresPerMile = DoubleStream.of(fares).map(x -> x * l).toArray();
		double gift = 20;
		double max = Double.MIN_NORMAL;
		int carIndex = -1;
		for (int x = 0; x < faresPerMile.length; x++) {
			if (max < faresPerMile[x] && faresPerMile[x] <= gift) {
				max = faresPerMile[x];
				carIndex = x;
			}
		}
		return carIndex == -1 ? "" : cars[carIndex];
	}

	public static void main(String[] args) {
		System.out.println(fancyRide(30, new double[] {0.3, 0.5, 0.7, 1, 1.3}));
	}

}

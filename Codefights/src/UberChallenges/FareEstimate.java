package UberChallenges;

public class FareEstimate {

	static double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
		double[] fareEstimate = new double[cost_per_minute.length];
		
		for(int x=0;x<cost_per_mile.length;x++) {
			fareEstimate[x] = (ride_time * cost_per_minute[x]) + (ride_distance * cost_per_mile[x]);
		}
		
		return fareEstimate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

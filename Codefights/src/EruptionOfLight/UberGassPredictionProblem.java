package EruptionOfLight;

import java.util.stream.DoubleStream;

public class UberGassPredictionProblem {
	static boolean gasPrediction(double[] driveDistances, double currentGasLevel, double avgMileage) {
		return (DoubleStream.of(driveDistances).sum() / (avgMileage * 12)) > currentGasLevel;
	}

	public static void main(String[] args) {
		System.out.println(gasPrediction(new double[] {12, 6, 17, 5, 20}, 0.25, 25));
	}

}

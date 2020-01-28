package looptunnel;

public class BurnCandles {
	static int candles(int candlesNumber, int makeNew) {
		int burnCandles = 0;
		int leftOvers = candlesNumber;
		while(candlesNumber > 0) {
			burnCandles += candlesNumber;
			candlesNumber = leftOvers/makeNew;
			leftOvers = (leftOvers/makeNew) + (leftOvers%makeNew);
		}
		return burnCandles;
	}

	public static void main(String[] args) {
//		System.out.println(5/2);
		System.out.println(candles(5, 2));
	}
}

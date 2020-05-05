package challenges;

public class RepeatedNumberUsingFloydAlgo {

	// Using floyd's hare and tortoise algorithm
	public int repeatedNumber(final int[] A) {
		int hare = A[0], tortoise = A[0];
		do {
			tortoise = A[tortoise];
			hare = A[A[hare]];
		} while (hare != tortoise);

		tortoise = A[0];
		while (tortoise != hare) {
			hare = A[hare];
			tortoise = A[tortoise];
		}
		return tortoise;
	}
}

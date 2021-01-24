import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

class PostOffice {
	private double distance;
	private int[] position;

	public PostOffice() {
	}

	public PostOffice(double distance, int[] position) {
		super();
		this.distance = distance;
		this.position = position;
	}

	public double getDistance() {
		return distance;
	}

	public int[] getPosition() {
		return position;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

}

public class KNearestPostOffices {

	/**
	 * Assume your location is [m, n] and the location of a post office is [p, q],
	 * the Euclidean distance between the office and you is SquareRoot((m - p) * (m
	 * - p) + (n - q) * (n - q)).
	 */
	public static int[][] kNearestPostOffice(int[][] postOffices, int k) {
		int[][] kNearestPosts = new int[k][2];

		Queue<PostOffice> min_heap = new PriorityQueue<>((p, q) -> Double.compare(p.getDistance(), q.getDistance()));

		for (int i = 0; i < postOffices.length; i++) {
			min_heap.add(
					new PostOffice(Math.sqrt(Math.pow((0 - postOffices[i][0]), 2) + Math.pow(0 - postOffices[i][1], 2)),
							postOffices[i]));
		}
		
		IntStream.range(0, k).forEach(x -> {
			kNearestPosts[x] = min_heap.poll().getPosition();
		});

		return kNearestPosts;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(
				kNearestPostOffice(new int[][] { { -16, 5 }, { -1, 2 }, { 4, 3 }, { 10, -2 }, { 0, 3 }, { -5, -9 } }, 3)));
	}
}

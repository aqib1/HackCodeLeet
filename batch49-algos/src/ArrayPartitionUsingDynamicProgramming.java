import java.util.stream.IntStream;

public class ArrayPartitionUsingDynamicProgramming {
	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 5, 5, 2, 11 }));
	}

	private static boolean canPartition(int[] d) {
		if (d == null || d.length <= 1)
			return false;

		int sum = IntStream.of(d).sum();
		if (sum % 2 != 0)
			return false;
		int limit = sum / 2;
		boolean[] results = new boolean[limit + 1];
		results[0] = true;

		for (int r : d) {
			for (int x = limit; x >= r; x--) {
				results[x] = results[x] || results[x - r];
			}
		}

		return results[limit];
	}

}

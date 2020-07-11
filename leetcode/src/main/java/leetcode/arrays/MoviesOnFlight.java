package leetcode.arrays;

import java.util.Arrays;

public class MoviesOnFlight {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(moviesDuration(new Integer[] { 69, 50, 20, 1 }, 100)));
	}

	// Movie duration O(logn * n^2) and space is O(2)
	public static int[] moviesDuration(Integer[] movies, int d) {
		Arrays.sort(movies, (c, y) -> y - c);
		int[] result = new int[2];
		int max = Integer.MIN_VALUE;
		for (int x = 0; x < movies.length - 1; x++)
			for (int y = x + 1; y < movies.length; y++) {
				int sum = movies[x] + movies[y];
				if (sum <= d - 30 && sum > max) {
					result[0] = movies[x];
					result[1] = movies[y];
					max = sum;
					break;
				}
			}
		return result;
	}
}

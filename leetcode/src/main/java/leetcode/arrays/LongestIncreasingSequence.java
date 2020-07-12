package leetcode.arrays;

import java.util.Arrays;

public class LongestIncreasingSequence {

	public static int getLongesSequence(int d[]) {
		if (d == null || d.length == 0)
			return 0;
		if (d.length == 1)
			return 1;
		int max = Integer.MIN_VALUE;
		int backtrack[] = new int[d.length];
		Arrays.fill(backtrack, 1);
		int j = 1;
		while (j < d.length) {
			for (int i = 0; i < j; i++) {
				if (d[i] <= d[j]) {
					backtrack[j] = backtrack[i] + 1;
					max = Math.max(max, backtrack[j]);
				}
			}
			j++;
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(getLongesSequence(new int[] { 1, 3, 5, 4, 7, 8, 9 }));

	}

}

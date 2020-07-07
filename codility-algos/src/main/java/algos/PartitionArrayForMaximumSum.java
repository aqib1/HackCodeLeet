package algos;

import java.util.stream.IntStream;

public class PartitionArrayForMaximumSum {

	public static void main(String[] args) {

		System.out.println(maxSumAfterPartitioning(new int[] { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 }, 4));
	}

	public static int maxSumAfterPartitioning(int[] A, int K) {
		if (K > A.length)
			return getMax(A, 0, A.length) * A.length;
		int sum = 0, countNo = 0, max = Integer.MIN_VALUE;
		for (int x = 0; x < A.length; x++) {
			if (countNo == K) {
				sum += A[x] + (max * countNo);
				countNo = 0;
				max = Integer.MIN_VALUE;
			} else {
				if (max < A[x]) {
					max = A[x];
				}
				countNo++;
			}
		}
		if (countNo != 0 && max != Integer.MAX_VALUE)
			sum += (max * countNo);
		return sum;
	}

	public static int getMax(int A[], int start, int end) {
		return IntStream.range(start, end).map(x -> A[x]).max().orElse(-1);
	}
}

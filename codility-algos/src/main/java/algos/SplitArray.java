package algos;

import java.util.Objects;
import java.util.stream.IntStream;

public class SplitArray {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 5, 5, 1, 5 }));
	}

	public static int solution(int X, int[] A) {
		if (Objects.isNull(A) || A.length == 0)
			return 0;
		long v = findResultByPivot(X, A, 0, A.length);
		return (int) v;
	}

	private static long findResultByPivot(int X, int[] a, int start, int end) {
		int mid = start + (end - start) / 2;
		while (mid >= 0 && mid < end) {
			long leftXEquals = IntStream.range(start, mid).map(x -> a[x]).filter(x -> X == x).count();
			long rightXNotEquals = IntStream.range(mid, end).map(x -> a[x]).filter(x -> X != x).count();
			if (leftXEquals == rightXNotEquals && (leftXEquals != 0 && rightXNotEquals != 0))
				return leftXEquals + rightXNotEquals;
			if (rightXNotEquals > leftXEquals)
				mid++;
			else
				mid--;
		}
		return a.length;
	}
}

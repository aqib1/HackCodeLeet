import java.util.Objects;

public class CostOfDividingChain {

	public static int solution(int[] A) {
		if (Objects.isNull(A) || A.length <= 4) {
			return 0;
		}
		int MIN_COST = Integer.MAX_VALUE;

		for (int x = 1; x < A.length - 1; x++) {
			for (int y = x + 2; y < A.length - 1; y++) {
				MIN_COST = Math.min(MIN_COST, A[x] + A[y]);
			}
		}

		return MIN_COST;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 5, 2, 4, 6, 3, 7 }));
	}
}

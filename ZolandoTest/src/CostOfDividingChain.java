import java.util.Objects;

public class CostOfDividingChain {
	
	public int solution2(int[] A) {
        if (Objects.isNull(A) || A.length <= 4) {
            return 0;
        }

        int MIN_COST_OF_CHAIN = Integer.MAX_VALUE;
        int p = 1, q = A.length - 2;

        while (p < q - 1) {
            MIN_COST_OF_CHAIN = Math.min(MIN_COST_OF_CHAIN, A[p] + A[q]);

            if (A[p] > A[q]) {
                p++;
            } else {
                q--;
            }
        }
        return MIN_COST_OF_CHAIN;
    }

	public static int solution(int[] A) {
		if (Objects.isNull(A) || A.length <= 4) {
			return 0;
		}
		int MIN_COST = Integer.MAX_VALUE;

		
		for (int p = 1; p < A.length - 3; p++) {
			for (int q = p + 2; q < A.length - 1; q++) {
				MIN_COST = Math.min(MIN_COST, A[p] + A[q]);
			}
		}

		return MIN_COST;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 1, 3, 0, -1, 5, 6 }));
	}
}

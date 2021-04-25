import java.util.Objects;

public class MaxSumContigousArray {

	// KADANE'S
	public static int maxSubArray(final int[] A) {
		if (Objects.isNull(A) || A.length == 0) {
			return 0;
		}
		int MAX_SUM = Integer.MIN_VALUE;
		int curr = A[0];
		for (int x = 1; x < A.length; x++) {
			curr = Math.max(A[x], curr + A[x]);
			if(MAX_SUM < curr) 
				MAX_SUM = curr;
		}
		
		return MAX_SUM;
	}
	
	public static void main(String[] args) {
		System.out.println(1/4);
		System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}

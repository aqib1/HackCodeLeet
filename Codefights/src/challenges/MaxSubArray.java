package challenges;

public class MaxSubArray {

	//KADANE'S Algorithm
	public int maxSubArray(final int[] A) {
		int max = A[0];
		int sum = A[0];
		for(int x = 1; x< A.length; x++) {
			sum = Math.max(sum + A[x], A[x]);
			if(max < sum) {
				max = sum;
			}
		}
		return max;
	}
}

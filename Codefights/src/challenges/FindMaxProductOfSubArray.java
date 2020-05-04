package challenges;

public class FindMaxProductOfSubArray {
	// using kadane's algorithm

	public int maxProduct(int[] nums) {
		int max_product = Integer.MIN_VALUE;
		for (int x = 0; x < nums.length; x++) {
			int prod = 1;
			for (int y = x; y >= 0; y--) {
				prod *= nums[y];
				max_product = Math.max(max_product, prod);
			}
		}
		return max_product;
	}
}

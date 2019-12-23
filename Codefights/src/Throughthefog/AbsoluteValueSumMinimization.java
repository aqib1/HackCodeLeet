package Throughthefog;

public class AbsoluteValueSumMinimization {
	static int absoluteValuesSumMinimization(int[] a) {
		int MIN_ABS = Integer.MAX_VALUE;
		int val = Integer.MAX_VALUE;
		for (int x = 0; x < a.length; x++) {
			int k = a[x];
			int absVal = 0;
			for (int y = 0; y < a.length; y++) {
				absVal += Math.abs(a[y] - k);
			}
			if (absVal < MIN_ABS) {
				val = k;
				MIN_ABS = absVal;
			} else if (absVal == MIN_ABS) {
				if (k < val) {
					val = k;
				}
			}
		}
		return val;
	}

	public static void main(String[] args) {
		System.out.println(absoluteValuesSumMinimization(new int[] { 2, 3 }));
	}
}

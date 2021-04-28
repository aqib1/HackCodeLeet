
public class OneBillionUsers {

	public static void main(String[] args) {
		System.out.println(getBillionUsersDay(new float[] {1.01f, 1.02f}));
	}
	public static int getBillionUsersDay(float[] growthRates) {
		int start = 1;
		int end = Integer.MAX_VALUE;
		double billion = 1e9;

		while (start < end) {
			double total = 0;
			int mid = start + (end - start) / 2;
			for (float growth : growthRates)
				total += growth(growth, mid);
			if (total == billion)
				return mid;
			else if (total > billion) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}

	private static double growth(float growth, int day) {
		return Math.pow(growth, day);
	}

}

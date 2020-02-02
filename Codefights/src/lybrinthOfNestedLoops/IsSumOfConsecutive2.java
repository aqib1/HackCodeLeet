package lybrinthOfNestedLoops;

public class IsSumOfConsecutive2 {

	static int isSumOfConsecutive2(int n) {
		if (n < 3)
			return 0;
		int count = 0;
		for (int x = 1; x <= n; x++) {
			int sum = x;
			for (int y = x + 1; y <= n; y++) {
				sum += y;
				if (sum == n) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// 7+8
		// 4+5+6
		// 
		System.out.println(isSumOfConsecutive2(15));
	}

}

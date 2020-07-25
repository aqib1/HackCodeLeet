package algorithm;

// HCF
public class Amazon2K20_HighestCommonFactor {

	// 2, 4, 6, 8

	public static void main(String[] args) {
		System.out.println(findGCF(new int[] { 12, 4, 6, 8 }));
	}

	public static int findGCF(int[] arr) {
		int least = 0;
		for (int a : arr) {
			least = HCF(least, a);
			if (least == 1)
				return 1;
		}

		return least;
	}

	public static int HCF(int a, int b) {
		if (a == 0)
			return b;

		return HCF(b % a, a);
	}
}

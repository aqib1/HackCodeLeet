package algorithm;

// HCF
public class Amazon2K20_HighestCommonFactor {

	public static void main(String[] args) {
		System.out.println(findHCF(new int[] { 12, 4, 6, 8 }));
	}

	public static int findHCF(int[] arr) {
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

		return HCF(a % b, a);
	}
}

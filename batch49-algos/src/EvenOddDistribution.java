
public class EvenOddDistribution {

	public static void main(String[] args) {
		EvenOddDistribution evenOddDistribution = new EvenOddDistribution();
		evenOddDistribution.printNo(10);
	}

	public int odd(int value) {
		if (value % 2 == 0)
			return even(value);
		return value + 1;
	}

	private int even(int value) {
		if (value % 2 != 0)
			return odd(value);
		return value - 1;
	}

	public void printNo(int k) {
		for (int x = 1; x <= k; x++)
			System.out.print(odd(x) + " ");
	}
}

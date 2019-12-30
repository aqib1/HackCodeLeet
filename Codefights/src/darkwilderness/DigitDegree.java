package darkwilderness;

public class DigitDegree {

	static int digitDegree(int n) {
		if (n < 10)
			return 0;
		int degree = 0;
		int divider = n / 10;
		int remainder = n % 10;
		int sum = 0;
		do {
			sum = 0;
			do {
				sum += remainder;
				int div = divider;
				divider = div / 10;
				remainder = div % 10;
			} while (remainder != 0);
			degree++;
			divider = sum;
		} while (sum >= 10);

		return degree;
	}

	public static void main(String[] args) {
		System.out.println(digitDegree(100));
	}
}

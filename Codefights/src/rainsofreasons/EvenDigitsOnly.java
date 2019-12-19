package rainsofreasons;

public class EvenDigitsOnly {
	// Return true if all digits of a number are even
	static boolean evenDigitsOnly(int n) {
		while (n > 0) {
			if ((n % 10) % 2 != 0) {
				return false;
			}
			n = n / 10;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(evenDigitsOnly(100));
	}
}

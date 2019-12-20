package Throughthefog;

public class CircleOfNumber {
	static int circleOfNumbers(int n, int firstNumber) {
		int halfOfN = n / 2;
		firstNumber += halfOfN;
		return firstNumber > (n - 1) ? (firstNumber - (n - 1)) - 1 : firstNumber;
	}

	public static void main(String[] args) {
		System.out.println(circleOfNumbers(5, 1));
	}
}

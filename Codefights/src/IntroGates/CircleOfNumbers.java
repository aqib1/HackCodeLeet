package IntroGates;

public class CircleOfNumbers {

	static int circleOfNumbers(int n, int firstNumber) {
		int div = n / 2;
		int val = div == n ? 0 : div > firstNumber ? div + firstNumber : firstNumber - div;
		return val;
	}

	public static void main(String[] args) {
		System.out.println(circleOfNumbers(4, 1));
	}

}

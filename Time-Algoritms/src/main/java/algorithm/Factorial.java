package algorithm;

public class Factorial {

	// tail recursion, as val * factorial which make recursion call is not
	// the last one
	// secondly its evaluating multiple after recursive call
	// time complexity is O(n) and space is O(n)
	public static int factorial(int val) {
		if (val == 1)
			return 1;

		return val * factorial(val - 1);
	}

	public static void main(String[] args) {
		System.out.println(factorial(4));

	}

}

package IntroGates;

import java.util.stream.IntStream;

public class MaxMultiple {

	static int maxMultiple(int divisor, int bound) {
		if (bound % divisor == 0)
			return bound;
		return maxMultiple(divisor, --bound);
	}

	static int maxMultipleWithStream(int divisor, int bound) {

		return IntStream.range(0, bound + 1).filter(x -> x % divisor == 0).max().getAsInt();
	}

	public static void main(String[] args) {

		System.out.println(maxMultipleWithStream(3, 10));
	}

}

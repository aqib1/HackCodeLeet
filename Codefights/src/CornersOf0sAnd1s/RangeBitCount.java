package CornersOf0sAnd1s;

import java.util.stream.IntStream;

public class RangeBitCount {
	static int rangeBitCount(int a, int b) {
		return IntStream.range(a, b+1).map(x -> Integer.bitCount(x)).sum();
	}

	public static void main(String[] args) {
		System.out.println(rangeBitCount(2, 7));
	}

}

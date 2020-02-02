package lybrinthOfNestedLoops;

import java.util.ArrayList;
import java.util.List;

public class SquareDigitsSequence {
	static int squareDigitsSequence(int a0) {
		String val = String.valueOf(a0);
		if (val.length() == 1)
			return 2;
		int count = 1;
		List<String> data = new ArrayList<>();
		data.add(val);
		do {
			int sum = 0;
			for (int x = 0; x < val.length(); x++) {
				sum += Math.pow(Integer.parseInt(String.valueOf(val.charAt(x))), 2);
			}
			val = String.valueOf(sum);
			count++;
		} while (!data.contains(val));
		return count;
	}

	public static void main(String[] args) {
		System.out.println(squareDigitsSequence(16));

	}

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SiblingInteger {
	public static int solution(int number) {
		if (number < 0)
			throw new RuntimeException("N should be non-negative number");
		if (number == 0)
			return 0;

		List<Integer> numbers = new ArrayList<Integer>();
		do {
			numbers.add(number % 10);
			number /= 10;
		} while (number > 0);

		Collections.sort(numbers);
		Collections.reverse(numbers);

		int result = numbers.get(0);
		for (int i = 1; i < numbers.size(); i++) {
			result = result * 10 + numbers.get(i);
			if (result > 100000000)
				return -1;
		}

		return result;
	}

	public int solution(int[] x, int[] y) {
		int maxX = 0;
		int maxY = 0;

		ArrayList<Integer> X = new ArrayList<>();
		ArrayList<Integer> Y = new ArrayList<>();

		IntStream.range(0, x.length).forEach(i -> {
			X.add(x[i]);
		});

		IntStream.range(0, y.length).forEach(i -> {
			Y.add(y[i]);
		});

		Collections.sort(X);
		Collections.sort(Y);

		for (int i = 1; i < X.size(); i++) {
			int j = X.get(i) - X.get(i - 1);
			maxX = j >= maxX ? j : maxX;
		}

		for (int i = 1; i < Y.size(); i++) {
			int j = Y.get(i) - Y.get(i - 1);
			maxY = j >= maxY ? j : maxY;
		}

		return maxX >= maxY ? maxX : maxY;
	}

	public static void main(String[] args) {
		
		int x = 6;
		System.out.println(x&1);
		
//		double[] d = new double[100000000];
//		long start = System.currentTimeMillis();
//		for (int x = 0; x < d.length; x++) {
//			for (int y = x + 1; y < d.length; y++) {
//				d[x] = d[x] + d[y];
//				System.out.println(x + ", "+ y);
//			}
//		}

//		System.out.println(System.currentTimeMillis() - start);
	}
}

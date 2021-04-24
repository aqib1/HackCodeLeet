import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RotateImage {

	public static void rotate1(List<List<Integer>> a) {
		if (Objects.isNull(a) || a.isEmpty()) {
			return;
		}

		// transpose matrix -> a[x] = a[y]

		for (int x = 0; x < a.size(); x++) {
			for (int y = x; y < a.get(x).size(); y++) {
				int temp = a.get(x).get(y);
				a.get(x).set(y, a.get(y).get(x));
				a.get(y).set(x, temp);
			}
		}

		// reverse
		for (int x = 0; x < a.size(); x++) {
			int colStart = 0;
			int colEnd = a.get(x).size() - 1;
			while (colStart < colEnd) {
				int temp = a.get(x).get(colStart);
				a.get(x).set(colStart, a.get(x).get(colEnd));
				a.get(x).set(colEnd, temp);
				colEnd--;
				colStart++;
			}
		}

	}

	public static void rotate(List<List<Integer>> a) {
		if (Objects.isNull(a))
			throw new IllegalArgumentException();
		// Transpose
		// x,y -> y,x
		for (int x = 0; x < a.size(); x++) {
			for (int y = x; y < a.get(x).size(); y++) {
				int temp = a.get(x).get(y);
				a.get(x).set(y, a.get(y).get(x));
				a.get(y).set(x, temp);
			}
		}
		for (int i = 0; i < a.size(); i++) {
			int col = 0;
			for (int last = a.get(i).size() - 1; last >= col; last--) {
				int tmp = a.get(i).get(col);
				a.get(i).set(col, a.get(i).get(last));
				a.get(i).set(last, tmp);
				col++;
			}
		}

	}

	public static void main(String[] args) {
		List<List<Integer>> a = new ArrayList<>();
		a.add(Arrays.asList(1, 2));
		a.add(Arrays.asList(3, 4));

		rotate1(a);

		System.out.println(a);
	}
}

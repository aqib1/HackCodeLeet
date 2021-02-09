import java.util.ArrayList;
import java.util.List;

public class Task3 {

	public static int[] burgerProblem(int X, int Y) {
		List<Integer> solution = new ArrayList<Integer>(2);
		double smallBurger = (double) ((4 * X) - Y) / 2;
		if ((smallBurger - (int) smallBurger != 0) || (smallBurger < 0)) {
			return new int[] { -1, -1 };
		}
		int big = X - (int) smallBurger;
		if (big < 0) {
			return new int[] { -1, -1 };
		}
		solution.add((int) smallBurger);
		solution.add(big);
		return solution.stream().mapToInt(i -> i).toArray();
	}
}

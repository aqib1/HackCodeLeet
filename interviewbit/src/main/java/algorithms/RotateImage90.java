package algorithms;

import java.util.ArrayList;
import java.util.Objects;

public class RotateImage90 {

	public void rotate(ArrayList<ArrayList<Integer>> a) {
		if (Objects.isNull(a))
			throw new IllegalArgumentException();
		for (int x = 0; x < a.size(); x++) {
			for (int y = x; y < a.get(x).size(); y++) {
				int temp = a.get(x).get(y);
				a.get(x).set(y, a.get(y).get(x));
				a.get(y).set(x, temp);
			}
		}

		for (int x = 0; x < a.size(); x++) {
			for (int y = 0; y < a.get(x).size() / 2; y++) {
				int temp = a.get(x).get(a.size() - 1 - y);
				a.get(x).set(a.size() - 1 - y, a.get(x).get(y));
				a.get(x).set(y, temp);
			}
		}
	}
}

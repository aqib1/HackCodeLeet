import java.util.EmptyStackException;
import java.util.Objects;

public class InsertionSort {

	// Time complexity is O(n)2 and space complexity is O(1)
	public int[] insertionSort(int[] array) {
		if (Objects.isNull(array) || array.length == 0)
			throw new EmptyStackException();
		if (array.length == 1)
			return array;
		for (int x = 1; x < array.length; x++) {
			for (int y = x; y > 0; y--) {
				if (array[y] < array[y - 1]) {
					int temp = array[y];
					array[y] = array[y - 1];
					array[y - 1] = temp;
				}
			}
		}

		return array;
	}
}

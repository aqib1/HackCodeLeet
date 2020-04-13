import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class CountSort {

	
	// Time complexity O(n+k) and space is O(n+k)
	public int[] countSort(int[] array) {
		if (Objects.isNull(array) || array.length == 0)
			throw new EmptyStackException();
		if (array.length == 1)
			return array;
		int maxValue = Arrays.stream(array).max().getAsInt();
		int minValue = Arrays.stream(array).min().getAsInt();
		int[] countOcc = new int[(maxValue - minValue) + 1];
		int[] sorted = new int[array.length];
		// count each element
		for (int x = 0; x < array.length; x++)
			countOcc[array[x] - minValue]++;
		// running sum
		for (int x = 1; x < countOcc.length; x++)
			countOcc[x] += countOcc[x - 1];
		for (int x = array.length - 1; x >= 0; x--) {
			sorted[countOcc[array[x] - minValue] - 1] = array[x];
			countOcc[array[x] - minValue]--;
		}

		return sorted;
	}
}

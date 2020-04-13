import java.util.EmptyStackException;
import java.util.Objects;
import java.util.stream.IntStream;

public class MergeSort {

	// Time complexity O(n log n) and space complexity is O(n)
	public void mergeSort(int[] array) {
		if (Objects.isNull(array) || array.length == 0)
			throw new EmptyStackException();
		if (array.length < 2) {
			return;
		}
		int mid = array.length / 2;
		int[] leftArray = IntStream.range(0, mid).map(x -> array[x]).toArray();
		int[] rightArray = IntStream.range(mid, array.length).map(x -> array[x]).toArray();
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(array, leftArray, rightArray);
	}

	public void merge(int[] array, int[] left, int[] right) {
		if (Objects.isNull(array) || Objects.isNull(left) || Objects.isNull(right)) {
			throw new EmptyStackException();
		}

		int pointer = 0, leftIndex = 0, rightIndex = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] < right[rightIndex]) {
				array[pointer++] = left[leftIndex++];
			} else {
				array[pointer++] = right[rightIndex++];
			}
		}
		while (leftIndex < left.length) {
			array[pointer++] = left[leftIndex++];
		}
		while (rightIndex < right.length) {
			array[pointer++] = right[rightIndex++];
		}
	}

}

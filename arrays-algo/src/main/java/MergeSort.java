import java.util.EmptyStackException;
import java.util.Objects;

public class MergeSort {

	public int[] mergeSort(int[] array) {
		if (Objects.isNull(array) || array.length == 0)
			throw new EmptyStackException();
		if (array.length == 1)
			return array;

		return null;
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

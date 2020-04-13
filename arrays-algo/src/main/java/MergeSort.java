import java.util.EmptyStackException;
import java.util.Objects;

public class MergeSort {

	public void mergeSort(int[] array) {
		if (Objects.isNull(array) || array.length == 0)
			throw new EmptyStackException();
		if (array.length < 2) {
			return;
		}
		int mid = array.length / 2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[array.length - mid];
		for (int x = 0; x < mid; x++)
			leftArray[x] = array[x];
		for (int y = 0, z = mid; y < rightArray.length && z < array.length; z++, y++)
			rightArray[y] = array[z];
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

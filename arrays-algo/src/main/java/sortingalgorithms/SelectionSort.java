package sortingalgorithms;
import java.util.EmptyStackException;
import java.util.Objects;

public class SelectionSort {

	// Time complexity is O(n)2 space complexity is O(1)
	public int[] selectionSort(int[] array) {
		if (Objects.isNull(array) || array.length == 0)
			throw new EmptyStackException();
		if (array.length == 1)
			return array;
		for (int x = 0; x < array.length; x++) {
			int min_val = Integer.MAX_VALUE;
			int min_index = x;
			for(int y = x; y < array.length; y++) 
				if(min_val > array[y]) {
					min_val = array[y];
					min_index = y;
				}
			int temp = array[x];
			array[x] = array[min_index];
			array[min_index] = temp;
			
		}
		return array;
	}
}

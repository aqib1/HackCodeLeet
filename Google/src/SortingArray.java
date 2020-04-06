import java.util.Arrays;

public class SortingArray {

	// Time complexity -> O(n)2
	// Space complexity -> O(1)
	public static int[] selectionSort(int[] array) {
		for (int x = 0; x < array.length; x++) {
			int comp_index = x;
			for (int y = x + 1; y < array.length; y++)
				if (array[x] > array[y]) {
					comp_index = y;
				}
			if (x != comp_index) {
				array[x] = array[x] + array[comp_index];
				array[comp_index] = array[x] - array[comp_index];
				array[x] = array[x] - array[comp_index];
			}
		}
		return array;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(selectionSort(new int[] { 0, 2, 1, 4 })));
	}

}

import java.util.Arrays;
import java.util.Objects;

public class FindFromArray {

	// O(LogN) + O(K) => if k == N then O(N)
	public static long findFast(int[] array, int v) {
		if (Objects.isNull(array) || array.length == 0)
			return -1;
		int index = binarySearch(array, v, 0, array.length - 1);
		if (index == -1)
			return -1;
		int count = 1;
		for (int x = index - 1; x >= 0; x--) {
			if (array[x] != v)
				break;
			count++;
		}
		for (int x = index + 1; x < array.length; x++) {
			if (array[x] != v)
				break;
			count++;
		}
		return count;
	}

	private static int binarySearch(int[] array, int v, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (array[mid] == v)
				return mid;
			if (array[mid] > v)
				return binarySearch(array, v, low, mid - 1);
			else
				return binarySearch(array, v, mid + 1, high);
		}
		return -1;
	}

	// O(n) ?????
	public static long find(int[] array, int v) {
		if (Objects.isNull(array) || array.length == 0)
			return -1;

		return Arrays.stream(array).filter(x -> x == v).count();
	}

	public static void main(String[] args) {
		System.out.println(findFastest(new int[] { 1, 2, 3, 3, 3, 4, 4, 5, 6, 7 }, 5));
	}

	private static int findFastest(int[] arr, int key) {
		if (Objects.isNull(arr) || arr.length == 0)
			return -1;

		int left = findLeftBinarySearch(arr, key, 0, arr.length - 1);
		if (left == -1)
			return -1;
		int right = findRightBinarySearch(arr, key, left, arr.length - 1);
		return right - left + 1;
	}

	private static int findRightBinarySearch(int[] arr, int key, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == arr.length - 1 || key < arr[mid + 1]) && arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				return findRightBinarySearch(arr, key, low, mid - 1);
			} else
				return findRightBinarySearch(arr, key, mid + 1, high);
		}

		return -1;
	}

	private static int findLeftBinarySearch(int[] arr, int key, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || key > arr[mid - 1]) && arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				return findLeftBinarySearch(arr, key, mid + 1, high);
			} else
				return findLeftBinarySearch(arr, key, low, mid - 1);
		}
		return -1;
	}
}

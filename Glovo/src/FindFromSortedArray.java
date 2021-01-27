import java.util.Arrays;
import java.util.Objects;

public class FindFromSortedArray {

	// More optimised solution
	// OLog(N) for left value
	// OLog(N) for right value
	// right - left + 1
	public static long findFastest(int[] arr, int key) {
		if (Objects.isNull(arr) || arr.length == 0)
			return -1;
		int left = findLeft(arr, key, 0, arr.length - 1);
		if (left == -1)
			throw new IllegalArgumentException("unknown key");
		int right = findRight(arr, key, left, arr.length - 1);
		return right - left + 1;
	}

	private static int findRight(int[] arr, int key, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == arr.length - 1 || key < arr[mid + 1]) && arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				return findRight(arr, key, low, mid - 1);
			} else {
				return findRight(arr, key, mid + 1, high);
			}
		}
		return -1;
	}

	private static int findLeft(int[] arr, int key, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || key > arr[mid - 1]) && arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				return findLeft(arr, key, mid + 1, high);
			} else {
				return findLeft(arr, key, low, mid - 1);
			}
		}
		return -1;
	}

	// binary search = Log N
	// k number elements count = k
	// O(K + Log(N)) in worst case k == N

	public static long findFast(int[] arr, int key) {
		if (Objects.isNull(arr) || arr.length == 0)
			return -1;
		int index = binerySearch(arr, key, 0, arr.length - 1);
		if (index == -1) {
			throw new IllegalArgumentException("unknown key");
		}
		int count = 1;
		for (int x = index - 1; x >= 0; x--) {
			if (arr[x] != key)
				break;
			count++;
		}
		for (int x = index + 1; x < arr.length; x++) {
			if (arr[x] != key)
				break;
			count++;
		}
		return count;
	}

	private static int binerySearch(int[] arr, int key, int first, int last) {
		int mid = first + (last - first) / 2;
		if (first <= last) {
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] > key) {
				return binerySearch(arr, key, first, mid - 1);
			} else {
				return binerySearch(arr, key, mid + 1, last);
			}
		}
		return -1;
	}

	// O(n) approach
	public static long find(int arr[], int key) {
		if (Objects.isNull(arr) || arr.length == 0)
			return -1;
		//
		return Arrays.stream(arr).filter(x -> x == key).count();
	}

	public static void main(String[] args) {
		System.out.println(findFastest(new int[] { 1, 2, 3, 3, 3, 4, 5, 6, 7 }, 3));
	}
}

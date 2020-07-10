import java.util.Objects;

public class FindKFromSorted {

	public static void main(String[] args) {
		System.out.println(findK(new int[] { 1, 2, 3, 4, 5, 6 }, 6));
	}

	// Time complexity is Log(n) and space is O(1)
	public static int findK(int[] arr, int k) {
		if (Objects.isNull(arr) || arr.length == 0)
			return -1;

		return binarySearch(arr, k, 0, arr.length);
	}

	private static int binarySearch(int[] arr, int k, int left, int right) {
		if (left > right)
			return -1;
		int mid = left + (right - left) / 2;
		if (arr[mid] == k)
			return mid;
		if (arr[mid] > k)
			return binarySearch(arr, k, left, mid - 1);
		return binarySearch(arr, k, mid + 1, right);
	}
}

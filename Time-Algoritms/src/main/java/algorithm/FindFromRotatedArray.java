package algorithm;

public class FindFromRotatedArray {
	// time complexity is Olog(n) and space is O(1)
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		if (nums[nums.length - 1] > nums[0]) {
			// its mean array is sorted not rotated
			return search(nums, 0, nums.length - 1, target);
		}
		int pivot = pivot(nums, 0, nums.length - 1);
		if (nums[pivot] == target)
			return pivot;
		if (target >= nums[0])
			return search(nums, 0, pivot - 1, target);
		return search(nums, pivot + 1, nums.length - 1, target);
	}

	public static int search(int arr[], int first, int last, int target) {
		if (first > last)
			return -1;
		int mid = first + (last - first) / 2;
		if (arr[mid] == target)
			return mid;
		if (target >= arr[mid])
			return search(arr, mid + 1, last, target);
		return search(arr, first, mid - 1, target);
	}

	// [5,1,2,3]
	// [5,6,7,2]
	static int pivot(int arr[], int low, int high) {
		/* low + (high - low)/2; */
		int mid = low + (high - low) / 2;
		// when mid element is pivot
		if (arr[mid] > arr[mid + 1])
			return mid;
		// when one element before mid is pivot
		if (mid > low && arr[mid - 1] > arr[mid])
			return mid - 1;

		if (arr[low] >= arr[mid])
			return pivot(arr, low, mid - 1);
		return pivot(arr, mid + 1, high);
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 1, 2, 3 }, 3));
	}

}

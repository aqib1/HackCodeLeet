package algorithm;

public class FindFromRotatedArray {
	// time complexity is Olog(n) and space is O(1)
	public static int search(int[] nums, int target) {
		int pivot = pivot(nums, 0, nums.length - 1);
		if (pivot == -1)
			return search(nums, 0, nums.length - 1, target);
		if (nums[pivot] == target)
			return pivot;
		if (target >= nums[0])
			return search(nums, 0, pivot - 1, target);
		return search(nums, pivot + 1, nums.length - 1, target);
	}

	public static int search(int arr[], int first, int last, int target) {
		if (first > last)
			return -1;
		int mid = (first + last) / 2;
		if (arr[mid] == target)
			return mid;
		if (target >= arr[mid])
			return search(arr, mid + 1, last, target);
		return search(arr, first, mid - 1, target);
	}

	static int pivot(int arr[], int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			if (low > 0)
				return -1;
			else
				return low;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return pivot(arr, low, mid - 1);
		return pivot(arr, mid + 1, high);
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 3, 5, 1 }, 3));
	}

}

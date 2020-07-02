package algorithm;

public class FindFromRotatedArray {
	public static int search(int[] nums, int target) {
		int pivot = pivot(nums, 0, nums.length - 1);
		if (nums[pivot] == target)
			return pivot;
		if (pivot == -1)
			return search(nums, 0, nums.length - 1, target);
		if (target > nums[0])
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

	public static int pivot(int[] arr, int first, int last) {
		if (first > last)
			return -1;
		if (first == last)
			return first;
		int mid = (last + first) / 2;
		if (mid < last && arr[mid] > arr[mid + 1])
			return mid;
		if (arr[first] > arr[mid])
			return pivot(arr, first, mid - 1);
		return pivot(arr, mid + 1, last);
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 2));
	}

}

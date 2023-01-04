public class BinarySearch {
    private int[] nums;
    // if provided nums array is already sorted then time complexity is O(LogN)
    // if provided nums array is not sorted then we need to sort it first
    // sort O(N x LogN) + binary search O(LogN) = O(N x LogN) + O(LogN) = O(NLogN)
    // Space complexity
    // { Due to recursion method calls occupied
    // space in stack as we are calling method half of iteration so space will be O(LogN)}
    // We can improve space complexity by using iterative approach.
    public int search(int[] nums, int target) {
        this.nums = nums;
        return bs(0, this.nums.length - 1, target);
    }

    public int bs(int start, int end, int target) {
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if(this.nums[mid] == target) return mid;

        if(target > this.nums[mid]) {
            return bs(mid + 1, end, target);
        } else {
            return bs(start, mid - 1, target);
        }
    }

    // binary search template I
    public int binarySearchI(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // binary search template II
    // find first smaller to target
    public static int binarySearchIIFindFirstSmallerTo(int[] nums, int target) {
        int start = 0, end = nums.length;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(target > nums[mid]) start = mid + 1;
            else end = mid;
        }
        if(start - 1 >= 0 && nums[start] == target) return nums[start - 1];

        return -1;
    }

    // binary search template II
    // find first smaller to target
    public static int binarySearchIIFindFirstGreaterTo(int[] nums, int target) {
        int low = 0, high = nums.length;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(target > nums[mid]) low = mid + 1;
            else high = mid;
        }

        if(high + 1 != nums.length && nums[high] == target) return nums[high + 1];
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(binarySearchIIFindFirstSmallerTo(new int [] {1, 2, 3, 4, 5, 6}, 4));
    }
}

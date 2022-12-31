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
        int mid = (start + end) / 2;
        if(this.nums[mid] == target) return mid;

        if(target > this.nums[mid]) {
            return bs(mid + 1, end, target);
        } else {
            return bs(start, mid - 1, target);
        }
    }
}

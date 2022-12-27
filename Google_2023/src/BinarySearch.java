public class BinarySearch {
    private int[] nums;
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

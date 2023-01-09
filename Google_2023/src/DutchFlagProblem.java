public class DutchFlagProblem {

    /**
     * Very famous Dutch flag problem (3 colors problem)
     * we start with 3 variables
     * start, mid and end.
     * start = 0,
     * mid = 0,
     * end = nums.length - 1,
     * 1)- if nums[mid] = 0, then we will swap nums[start] & nums[mid]
     * and increment start, mid
     * 2)- if nums[mid] = 1, we simply increment mid
     * 3)- if nums[mid] =2, we will swap nums[mid], nums[end]
     * and decrement end.
     *
     * we continue iteration until mid <= end
     *
     * Time complexity is O(n), space O(1)
     * */
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;

        while(mid <= end) {
            if(nums[mid] == 0) {
                swap(nums, start, mid);
                mid++;
                start++;
            } else if(nums[mid] == 2) {
                swap(nums, mid, end);
                end--;
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

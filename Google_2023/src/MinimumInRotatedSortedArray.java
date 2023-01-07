import java.util.Objects;

public class MinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int [] {4,5,1,2,3}));
    }
}

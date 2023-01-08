import java.util.Objects;

public class RangeSearch {
    public int[] searchRange(int[] nums, int target) {
        if(Objects.isNull(nums) || nums.length == 0) return null;
        int[] result = {-1, -1};

        result[0] = searchRange(nums, target, true);
        result[1] = searchRange(nums, target, false);
        return result;
    }

    private int searchRange(int[] nums, int target, boolean isLeft) {
        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                if(isLeft) {
                    if(start == mid || nums[mid - 1] != target) return mid;
                    end = mid - 1;
                } else {
                    if(end == mid || nums[mid + 1] != target) return mid;

                    start = mid + 1;
                }
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return -1;
    }
}

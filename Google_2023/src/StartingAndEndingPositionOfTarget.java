import java.util.Arrays;
import java.util.Objects;

public class StartingAndEndingPositionOfTarget {

    public static int[] searchRange(int[] nums, int target) {
        if(Objects.isNull(nums)) return new int[] {-1, -1};

        int [] result = {-1, -1};
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);
        return result;
    }

    private static int binarySearch(int [] nums, int target ,boolean isFirst) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                if(isFirst) {
                    if(mid == start || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    if(mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
}

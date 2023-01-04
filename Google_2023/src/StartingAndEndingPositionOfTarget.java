import java.util.Arrays;
import java.util.Objects;

public class StartingAndEndingPositionOfTarget {

    public static int[] searchRange(int[] nums, int target) {
        if(Objects.isNull(nums)) return new int[] {-1, -1};


        int [] result = {-1, -1};
        int start = 0, end = nums.length;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(target > nums[mid]) start = mid + 1;
            else end = mid;
        }
        if(start != nums.length && nums[start] == target) {
            result[0] = start;
            while(start + 1 != nums.length && nums[start + 1] == target) {
                ++start;
            }
            result[1] = start;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
    }
}

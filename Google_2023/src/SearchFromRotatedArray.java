import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SearchFromRotatedArray {
    // Time complexity ONLog(N) + OLog(N) = ON(LogN)
    // Space O(N)
    public int search(int[] nums, int target) {
        Map<Integer, Integer> valueByIndex = new HashMap<>();
        IntStream.range(0, nums.length).forEach(x -> valueByIndex.put(nums[x], x));

        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return valueByIndex.get(nums[mid]);
            if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

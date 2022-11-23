import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {

    // time O(n) & spcae O(n)
    public static boolean containsDuplicate(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return false;
        }
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : nums)
            if (uniqueElements.contains(num)) return true;
            else uniqueElements.add(num);

        return false;
    }

    // Space O(1) Time O(nlogn)
    public static boolean constantSpaceContainsDuplicate(int [] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);

        for(int x=0; x < nums.length - 1; x++) {
            if(nums[x] == nums[x+1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(constantSpaceContainsDuplicate(new int []{1, 2, 2, 1}));
    }
}

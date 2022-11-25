import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Set<Integer> diffHolder = new HashSet<>();
        Map<Integer, Integer> indexByNum = new HashMap<>();
        for (int x = 0; x < nums.length; x++) {
           if(diffHolder.contains(target - nums[x])) {
               return new int[] {indexByNum.get(target - nums[x]), x};
           } else {
               diffHolder.add(nums[x]);
               indexByNum.put(nums[x], x);
           }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                twoSum(new int[]{3, 2 ,3}, 6)
        ));
    }
}

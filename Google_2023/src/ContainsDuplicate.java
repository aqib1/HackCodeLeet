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

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int []{1, 2, 3}));
    }
}

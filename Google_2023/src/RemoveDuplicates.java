import java.util.Objects;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int k = 1, match = 0;
        for(int start = 0; start < nums.length - 1; start++) {
            if(nums[start] == nums[start + 1]) {
                match++;
            } else {
                nums[k] = nums[match + 1];
                match = start + 1;
                k++;

            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1, 1, 2}));
    }

}

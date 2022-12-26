import java.util.Objects;

public class ConstructBTFromSortedArray {

    // PRE-ORDER with choosing mid-value as root.

    private int []nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        if(Objects.isNull(nums)) return null;
        this.nums = nums;

        return constructBT(0, nums.length - 1);
    }

    private TreeNode constructBT(int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBT(start, mid - 1);
        root.right = constructBT(mid + 1, end);

        return root;
    }

}

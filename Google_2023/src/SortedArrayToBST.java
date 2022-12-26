import java.util.Objects;

public class SortedArrayToBST {

    //constructing height balanced binary tree from sorted array
    //can be done using pre-order traversal and always choose
    //middle value as root

    private int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        if(Objects.isNull(nums)) return null;
        this.nums = nums;

        return constructBT(0, nums.length - 1);
    }

    public TreeNode constructBT(int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBT(start, mid - 1);
        root.right = constructBT(mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(1 / 2);
    }
}

import java.util.Objects;

public class IsValidBST {

    // Time complexity O(N) where N is number of nodes
    // Space complexity O(N) due to recursion
    public boolean validateBT(TreeNode node) {
        return validateBT(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validateBT(TreeNode node, long low, long high) {
        if(Objects.isNull(node)) return true;
        if(node.val <= low || node.val >= high) return false;

        return validateBT(node.left, low, node.val) &&
                validateBT(node.right, node.val, high);
    }


























    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min, long max) {
        if(Objects.isNull(root)) return true;
        if(root.val <= min || root.val >= max)
            return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}

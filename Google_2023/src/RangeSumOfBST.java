public class RangeSumOfBST {

    // Time complexity in worst case O(N)
    // Space complexity O(N)
    private int count;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
         count = 0;
        InOrder(root, low, high);
        return count;
    }

    public void InOrder(TreeNode root, int low, int high) {
        if(root == null) return;
        InOrder(root.left, low, high);
        if(root.val >= low && root.val <= high) count+= root.val;
        InOrder(root.right, low, high);
    }
}

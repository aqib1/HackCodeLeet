public class CorrespondingNodes {
    private TreeNode result;
    private TreeNode target;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        getTargetCopy(original, cloned);

        return result;
    }

    public final void getTargetCopy(TreeNode original, TreeNode cloned) {
        if(original == null) return;

        getTargetCopy(original.left, cloned.left);

        if(original == target)  {
            result = cloned;
        }

        getTargetCopy(original.right, cloned.right);
    }
}

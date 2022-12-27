public class FloorAndCeilingBst {


    private int max;
    public int ceil(TreeNode node, int key) {
        max = Integer.MAX_VALUE;
        findCeil(node, key);
        return max;
    }

    public void findCeil(TreeNode node, int key) {
        if(node == null) return;

        if(node.val >= key && node.val <= max) {
            max = node.val;
        }

        findCeil(node.left, key);
        findCeil(node.right, key);
    }
}

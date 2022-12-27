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

    private int min;
    public int floor(TreeNode node, int key) {
        min = Integer.MIN_VALUE;
        findFloor(node, key);
        return min;
    }

    private void findFloor(TreeNode node, int key) {
        if(node == null) return;
        if(node.val <= key && node.val >= min) {
            min = node.val;
        }

        findFloor(node.left, key);
        findFloor(node.right, key);
    }
}

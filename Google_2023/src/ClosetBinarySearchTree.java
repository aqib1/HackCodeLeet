import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class ClosetBinarySearchTree {
    public static int closestValue(TreeNode root, double target) {

        target = Math.round(target);
        double closest = Double.MAX_VALUE;
        int result = -1;
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while(!bfs.isEmpty()) {
            TreeNode node = bfs.remove();
            if(!Objects.isNull(node)) {
                if(target == node.val) return node.val;
                else if(Math.abs(node.val - target) < closest) {
                    closest = Math.abs(node.val - target);
                    result = node.val;
                }
                if(node.left != null && target < node.val) {
                    bfs.add(node.left);
                }
                if(node.right != null && target > node.val) {
                    bfs.add(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(5);

        System.out.println(closestValue(root, 3.4));
    }

}

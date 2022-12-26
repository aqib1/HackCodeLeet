import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class InvertOfBT {
    // BFS
    public TreeNode invertTree(TreeNode root) {
        if(Objects.isNull(root)) return null;
        Queue<TreeNode> fifoQueue = new LinkedList<>();
        fifoQueue.add(root);
        while (!fifoQueue.isEmpty()) {
            TreeNode node = fifoQueue.remove();
            if(!Objects.isNull(node)) {
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                fifoQueue.add(node.left);
                fifoQueue.add(node.right);
            }
        }
        return root;
    }

    public TreeNode dfs(TreeNode root) {
        if(!Objects.isNull(root)) {
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            dfs(root.left);
            dfs(root.right);
        }
        return root;
    }
}

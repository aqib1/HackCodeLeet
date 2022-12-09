import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    // NLR preorder DFS
    public void preorderTraversal(TreeNode node, List<Integer> result) {
        if(Objects.isNull(node)) return;

        result.add(node.val);

        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }
}

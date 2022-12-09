import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    // L-R-N post-order
    public void postorderTraversal(TreeNode root, List<Integer> result) {
        if(Objects.isNull(root)) return;

        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);

        result.add(root.val);
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(result, root, 0);
        return result;
    }

    public void levelOrderTraversal(List<List<Integer>> result, TreeNode root, int height) {
        if(Objects.isNull(root)) return;

        if(height == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);

        levelOrder(result, root.left, height + 1);
        levelOrder(result, root.right, height + 1);
    }

    public void levelOrder(List<List<Integer>> nodes, TreeNode node, int height) {
        if(Objects.isNull(node)) return;
        if(height == nodes.size()) {
            nodes.add(new ArrayList<>());
        }
        nodes.get(height).add(node.val);
        levelOrder(nodes, node.left, height + 1);
        levelOrder(nodes, node.right, height + 1);
    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LevelOrderBT {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(Objects.isNull(root)) return result;
        levelOrder(root, 0);
        return result;

    }

    public void levelOrder(TreeNode node, int height) {
        if(Objects.isNull(node)) return;
        if(height == result.size()) result.add(new ArrayList<>());

        result.get(height).add(node.val);

        levelOrder(node.left, height + 1);
        levelOrder(node.right, height + 1);
    }
}

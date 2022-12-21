import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueBTII {
    public LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_Trees = new LinkedList<>();

        if(start > end) {
            all_Trees.add(null);
            return all_Trees;
        }

        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftNodes = generate_trees(start, i - 1);
            LinkedList<TreeNode> rightNodes = generate_trees(i + 1, end);

            for(TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;

                    all_Trees.add(root);
                }
            }
        }

        return all_Trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();

        return generate_trees(1, n);
    }
}

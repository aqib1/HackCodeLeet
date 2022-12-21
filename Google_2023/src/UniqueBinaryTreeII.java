import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTreeII {
    public static List<TreeNode> generate_trees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if(start > end) {
            allTrees.add(null); // leaf nodes
            return allTrees;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generate_trees(start, i - 1);
            List<TreeNode> rightNodes = generate_trees(i + 1, end);

            for(TreeNode leftNode : leftNodes) {
                for(TreeNode rightNode: rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    allTrees.add(node);
                }
            }
        }

        return allTrees;
    }

    public static List<TreeNode> generateTrees(int n) {
        if(n <= 0) return new ArrayList<>();

        return generate_trees(1, n);
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
}

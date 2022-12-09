import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindLeafOfBinaryTree {
    public static List<List<Integer>> findLeaves(TreeNode root) {
        if (Objects.isNull(root)) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        while(!Objects.isNull(root)) {
            List<Integer> leaves = new ArrayList<>();
            root = findLeaves(root, leaves);
            result.add(leaves);
        }
        return result;
    }

    // N-L-R (Pre-Order)
    public static TreeNode findLeaves(TreeNode root, List<Integer> leaves) {
        if (Objects.isNull(root)) return null;
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            leaves.add(root.val);
            return null;
        }

        root.left = findLeaves(root.left, leaves);
        root.right = findLeaves(root.right, leaves);
        return root;
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(17);
        System.out.println(findLeaves(treeNode));
    }
}

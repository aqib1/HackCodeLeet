import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecoverBinaryTree {

    // space O(N)
    // time O(N) + O(N) + O(N) = O3(N) = O(N)
    public static void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inOrder(root, nodes);

        int [] incorrectNodes = twoInCorrectNodes(nodes);
        replaceValues(root, incorrectNodes);
    }

    private static void replaceValues(TreeNode root, int[] incorrectNodes) {
        if(Objects.isNull(root)) return;

        if(root.val == incorrectNodes[0] || root.val == incorrectNodes[1]) {
           root.val = root.val == incorrectNodes[0] ? incorrectNodes[1] : incorrectNodes[0];
        }

        replaceValues(root.left, incorrectNodes);
        replaceValues(root.right, incorrectNodes);
    }

    private static int[] twoInCorrectNodes(List<TreeNode> nodes) {
        int[] result = new int[2];
        boolean swapped_first_occurrence = false;
        for(int x=0; x<nodes.size() - 1; x++) {
            if(nodes.get(x+1).val < nodes.get(x).val) {
                result[0] = nodes.get(x+1).val;
                if(!swapped_first_occurrence) {
                    result[1] = nodes.get(x).val;
                    swapped_first_occurrence = true;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static void inOrder(TreeNode root, List<TreeNode> inOrder) {
        if(root == null) return;

        inOrder(root.left, inOrder);
        inOrder.add(root);
        inOrder(root.right, inOrder);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(1);

        recoverTree(treeNode);
        System.out.println(treeNode);
    }
}

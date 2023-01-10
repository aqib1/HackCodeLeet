import java.util.*;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> bfs = new LinkedList<>();
        Map<Integer, TreeNode> parentNode = new HashMap<>();
        parentNode.put(root.val, null);
        bfs.add(root);

        // capture parent against each node until we reach p and q
        while(!parentNode.containsKey(p.val) || !parentNode.containsKey(q.val)) {
            TreeNode node = bfs.remove();
            if(!Objects.isNull(node.left)) {
                parentNode.put(node.left.val, node);
                bfs.add(node.left);
            }
            if(!Objects.isNull(node.right)) {
                parentNode.put(node.right.val, node);
                bfs.add(node.right);
            }
        }

        Set<Integer> ancestors = new HashSet<>();

        // record all parents of p in a set
        while(!Objects.isNull(p)) {
            ancestors.add(p.val);
            p = parentNode.get(p.val);
        }

        // record all parent of q until we reach to a common parent of
        // p and q
        while(!Objects.isNull(q) && !ancestors.contains(q.val)) {
            q = parentNode.get(q.val);
        }

        return q;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);

        System.out.println(lowestCommonAncestor(node, new TreeNode(1), new TreeNode(2)));


    }
}

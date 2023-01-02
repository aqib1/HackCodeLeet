import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    static class Pair {
        TreeNode node;
        int location;
        Pair(TreeNode node, int location) {
            this.node = node;
            this.location = location;
        }
    }
    // Time complexity O(N) + ON(Log N) = O 2N(LogN) = ON(Log N) where N is number of nodes
    // Space complexity O(N)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(Objects.isNull(root)) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> orderByKey = new HashMap<>();
        Queue<Pair> bfs = new LinkedList<>();
        bfs.add(new Pair(root, 0));

        while(!bfs.isEmpty()) {
            Pair node = bfs.remove();
            orderByKey.putIfAbsent(node.location, new ArrayList<>());
            orderByKey.get(node.location).add(node.node.val);

            if(!Objects.isNull(node.node.left)) {
                bfs.add(new Pair(node.node.left, node.location - 1));
            }
            if(!Objects.isNull(node.node.right)) {
                bfs.add(new Pair(node.node.right, node.location + 1));
            }
        }
        orderByKey.keySet().stream().sorted().forEach(key -> result.add(orderByKey.get(key)));
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal b = new BinaryTreeVerticalOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(b.verticalOrder(root));
    }
}

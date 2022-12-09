import java.util.*;

public class BTLevelOrder {

    static class LevelTree {
        TreeNode root;
        int height;

        LevelTree() {

        }

        LevelTree(TreeNode root, int height) {
            this.root = root;
            this.height = height;
        }


    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(Objects.isNull(root)) return new ArrayList<>();

        final List<List<Integer>> result = new ArrayList<>();
        final HashMap<Integer, List<Integer>> nodesByHeight = new HashMap<>();
        final Queue<LevelTree> fifoQueue = new LinkedList<>();
        fifoQueue.add(new LevelTree(root, 0));

        while(!fifoQueue.isEmpty()) {
            LevelTree first = fifoQueue.poll();
            List<Integer> rootsByLevel =
                    nodesByHeight.getOrDefault(first.height, new ArrayList<>());
            rootsByLevel.add(first.root.val);
            nodesByHeight.put(first.height, rootsByLevel);

            if(!Objects.isNull(first.root.left)) {
                fifoQueue.add(new LevelTree(first.root.left, first.height + 1));
            }
            if(!Objects.isNull(first.root.right)) {
                fifoQueue.add(new LevelTree(first.root.right, first.height + 1));
            }
        }

        int height  = 0;
        while(nodesByHeight.containsKey(height)) {
            result.add(nodesByHeight.get(height));
            height++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(17);

        System.out.println(levelOrder(treeNode));
    }
}

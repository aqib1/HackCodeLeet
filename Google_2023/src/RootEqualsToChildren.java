import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class RootEqualsToChildren {


    public boolean checkTree(TreeNode root) {
        if(Objects.isNull(root)) return false;
        boolean res = true;
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while(!bfs.isEmpty()) {
            TreeNode node = bfs.remove();
            if(!Objects.isNull(node)) {
                if(!Objects.isNull(node.left)
                        && !Objects.isNull(node.right)
                            && node.val != (node.left.val + node.right.val)) return false;

                bfs.add(node.left);
                bfs.add(node.right);
            }

        }
        return res;
    }
}

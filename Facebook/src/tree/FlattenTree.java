package tree;

public class FlattenTree {

	private TreeNode previous = null;
	
	public void flatten(TreeNode root) { 
		if(root == null)
			return;
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		if(previous != null) {
			previous.right = root;
			previous.left = null;
		}
		
		previous = root;
		
		flatten(left);
		flatten(right);
	}
}

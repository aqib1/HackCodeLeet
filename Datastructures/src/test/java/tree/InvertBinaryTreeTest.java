package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvertBinaryTreeTest {
	private InvertBinaryTree invertBinaryTree;

	@Before
	public void init() {
		invertBinaryTree = new InvertBinaryTree();
	}

	public void testInvertTree() {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);

		TreeNode result = invertBinaryTree.invertTree(treeNode);
		Assert.assertTrue(result.val == 1);
		Assert.assertTrue(result.left.val == 3);
		Assert.assertTrue(result.right.val == 2);
	}

	@Test
	public void testInvertTreeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "invertTree";
		Class<?> c = InvertBinaryTree.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}
}

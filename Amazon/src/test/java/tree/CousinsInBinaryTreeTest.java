package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CousinsInBinaryTreeTest {

	private CousinsInBinaryTree cousin;

	@Before
	public void init() {
		cousin = new CousinsInBinaryTree();
	}

	@Test
	public void testIsCousins() {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.right.right = new TreeNode(5);

		Assert.assertTrue(cousin.isCousins(tree, 4, 5));
	}

	@Test
	public void testIsCousinsMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "isCousins";
		Class<?> c = CousinsInBinaryTree.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class, int.class, int.class);
		Assert.assertNotNull(method);
	}
}

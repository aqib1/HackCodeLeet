package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsBalancedTreeTest {
	private IsBalancedTree isBalancedTree;

	@Before
	public void init() {
		isBalancedTree = new IsBalancedTree();
	}

	@Test
	public void testIsBalanced() {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		Assert.assertTrue(isBalancedTree.isBalanced(tree));
	}

	@Test
	public void testIsBalancedMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "isBalanced";
		Class<?> c = IsBalancedTree.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}
}

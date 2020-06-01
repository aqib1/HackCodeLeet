package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeFlatterTest {
	private BinaryTreeFlatter binaryTreeFlatter;

	@Before
	public void init() {
		binaryTreeFlatter = new BinaryTreeFlatter();
	}

	@Test
	public void testFlatten() {
		TreeNode node = new TreeNode(6);
		node.left = new TreeNode(3);
		node.left.right = new TreeNode(2);
		binaryTreeFlatter.flatten(node);

		TreeNode expected = new TreeNode(6);
		node.right = new TreeNode(3);
		node.right.right = new TreeNode(2);
		binaryTreeFlatter.flatten(node);
		Assert.assertEquals(expected, node);

	}

	@Test
	public void testFlattenMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "flatten";
		Class<?> c = BinaryTreeFlatter.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}

}

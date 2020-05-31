package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumBTFromArrayTest {
	private MaximumBTFromArray maximumBTFromArray;

	@Before
	public void init() {
		maximumBTFromArray = new MaximumBTFromArray();
	}

	@Test
	public void testConstructMaximumBinaryTree() {
		TreeNode node = new TreeNode(6);
		node.left = new TreeNode(3);
		node.left.right = new TreeNode(2);
		node.left.right.right = new TreeNode(1);
		node.right = new TreeNode(5);
		node.right.left = new TreeNode(0);
		int[] data = new int[] { 3, 2, 1, 6, 0, 5 };
	}

	@Test
	public void testConstructMaximumBinaryTreeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "constructMaximumBinaryTree";
		Class<?> c = MaximumBTFromArray.class;
		Method method = c.getDeclaredMethod(methodName, int[].class);
		Assert.assertNotNull(method);
	}

}

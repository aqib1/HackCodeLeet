package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxWidthOfBTTest {
	private MaxWidthOfBT maxWidthOfBT;

	@Before
	public void init() {
		maxWidthOfBT = new MaxWidthOfBT();
	}

	@Test
	public void testMaxWidthOfBTTest() {
		TreeNode treeNode = new TreeNode(1);
		treeNode.right = new TreeNode(2);

		int result = maxWidthOfBT.widthOfBinaryTree(treeNode);
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testMaxWidthOfBTTestMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "widthOfBinaryTree";
		Class<?> c = MaxWidthOfBT.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}
}

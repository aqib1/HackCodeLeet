package tree;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumDepthTest {
	private MaximumDepth maximumDepth;

	@Before
	public void init() {
		maximumDepth = new MaximumDepth();
	}

	@Test
	public void testMaxDepth() {
		TreeNode node = new TreeNode(6);
		node.left = new TreeNode(3);
		Assert.assertTrue(maximumDepth.maxDepth(node) == 2);
	}

	@Test
	public void testConstructMaximumBinaryTreeMethod() throws NoSuchMethodException, SecurityException {
		String methodName = "maxDepth";
		Class<?> c = MaximumDepth.class;
		Method method = c.getDeclaredMethod(methodName, TreeNode.class);
		Assert.assertNotNull(method);
	}
}
